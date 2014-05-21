import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

// TODO: Auto-generated Javadoc
/**
 * The Class DBManager.
 */
public class DBManager {

    /** The db helper. */
    private DBHelper dbHelper;

    /** The db. */
    private SQLiteDatabase db;

    /** The Constant USER_TABLE. */
    public static final String USER_TABLE = "Users";

    /** The Constant USER_NAME. */
    public static final String USER_NAME = "username";

    /** The Constant USER_PASS. */
    public static final String USER_PASS = "password";

    /** The Constant USER_ID. */
    public static final String USER_ID = "_id";

    /** The Constant ACCOUNT_NAME. */
    public static final String ACCOUNT_NAME = "account_name";

    /** The Constant DISPLAY_NAME. */
    public static final String DISPLAY_NAME = "display_name";

    /** The Constant BALANCE. */
    public static final String BALANCE = "balance";

    /** The Constant INTEREST_RATE. */
    public static final String INTEREST_RATE = "interest_rate";

    /** The Constant ACCOUNTS_TABLE. */
    public static final String ACCOUNTS_TABLE = "Accounts";

    /** The Constant TRANSACTIONS_TABLE. */
    public static final String TRANSACTIONS_TABLE = "Transactions";
    
    /** The Constant DATE_FORMAT. */
    public static final String DATE_FORMAT = "yyyyMMdd";

    /**
     * Instantiates a new DB manager.
     * 
     * @param context
     *            the context
     */
    public DBManager(Context context) {
        dbHelper = new DBHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    /**
     * Creates the user.
     * 
     * @param user
     *            the user
     * @param pass
     *            the pass
     * @return the long
     */
    public long createUser(String user, String pass) {
        ContentValues values = new ContentValues();
        values.put(USER_NAME, user);
        values.put(USER_PASS, pass);
        return db.insert(USER_TABLE, null, values);
    }

    /**
     * Creates the transaction.
     * 
     * @param id
     *            the id
     * @param userId
     *            the user id
     * @param type
     *            the type
     * @param name
     *            the name
     * @param amount
     *            the amount
     * @param date
     *            the date
     * @param category
     *            the category
     * @return the long
     */
    public long createTransaction(int id, int userId, String type, String name,
        double amount, Date date, String category) {
        ContentValues values = new ContentValues();
        values.put("account_id", id);
        values.put("user_id", userId);
        values.put("transaction_type", type);
        values.put("transaction_name", name);
        values.put("amount", amount);
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        String d = dateFormat.format(date);

        values.put("date", Integer.parseInt(d));
        values.put("category", category);
        return db.insert(TRANSACTIONS_TABLE, null, values);
    }

    /**
     * Creates the account.
     * 
     * @param id
     *            the id
     * @param accountName
     *            the account name
     * @param displayName
     *            the display name
     * @param balance
     *            the balance
     * @param interestRate
     *            the interest rate
     * @return the long
     */
    public long createAccount(int id, String accountName, String displayName,
        double balance, double interestRate) {
        ContentValues values = new ContentValues();
        values.put("user_id", id);
        values.put(ACCOUNT_NAME, accountName);
        values.put(DISPLAY_NAME, displayName);
        values.put(BALANCE, balance);
        values.put(INTEREST_RATE, interestRate);
        return db.insert(ACCOUNTS_TABLE, null, values);
    }

    /**
     * Gets the user id.
     * 
     * @param user
     *            the user
     * @return the user id
     */
    public int getUserId(String user) {
        String[] args = {user};
        Cursor c = db.rawQuery("SELECT _id FROM " + USER_TABLE
            + " where username" + "=?", args);
        if (c != null) {
            if (c.moveToFirst()) {
                return c.getInt(c.getColumnIndex(USER_ID));
            }
        }

        return -1;
    }

    /**
     * Gets the account id.
     * 
     * @param accountName
     *            the account name
     * @param userId
     *            the user id
     * @return the account id
     */
    public int getAccountId(String accountName, int userId) {
        String[] args = {String.valueOf(userId), accountName};
        Cursor c = db
            .rawQuery(
                "SELECT _id FROM Accounts where user_id=? AND display_name=?",
                args);
        if (c != null) {
            if (c.moveToFirst()) {
                return c.getInt(c.getColumnIndex("_id"));
            }
        }
        return -1;
    }

    /**
     * Gets the pass.
     * 
     * @param user
     *            the user
     * @return the pass
     */
    public String getPass(String user) {
        String[] args = {user};
        Cursor c = db.rawQuery("SELECT password FROM " + USER_TABLE
            + " where username" + "=?", args);
        if (c != null) {
            if (c.moveToFirst()) {
                return c.getString(c.getColumnIndex(USER_PASS));
            }
        }

        return null;
    }

    /**
     * Update account balance.
     * 
     * @param accountId
     *            the account id
     * @param newBalance
     *            the new balance
     * @return the long
     */
    public long updateAccountBalance(int accountId, double newBalance) {
        ContentValues values = new ContentValues();
        values.put("balance", newBalance);
        String where = "_id=?";
        return db.update(ACCOUNTS_TABLE, values, where, new String[] {String
            .valueOf(accountId)});
    }

    /**
     * Gets the account balance.
     * 
     * @param accountId
     *            the account id
     * @return the account balance
     */
    public double getAccountBalance(int accountId) {
        String[] args = {String.valueOf(accountId)};
        Cursor c = db
            .rawQuery("SELECT balance FROM Accounts where _id=?", args);
        if (c != null) {
            if (c.moveToFirst()) {
                return c.getDouble(c.getColumnIndex("balance"));
            }
        }
        return 0;
    }

//    /**
//     * Gets the account.
//     * 
//     * @param accountId
//     *            the account id
//     * @return the account
//     */
//    public Account getAccount(int accountId) {
//        String[] args = {String.valueOf(accountId)};
//        Cursor c = db.rawQuery("SELECT * FROM Accounts where _id=?", args);
//        if (c != null) {
//            if (c.moveToFirst()) {
//                String accName = c.getString(c.getColumnIndex(ACCOUNT_NAME));
//                String dispName = c.getString(c.getColumnIndex(DISPLAY_NAME));
//                double bal = c.getDouble(c.getColumnIndex(BALANCE));
//                double ir = c.getDouble(c.getColumnIndex(INTEREST_RATE));
//                return new Account(accName, dispName, bal, ir);
//            }
//        }
//        return null;
//    }
//
//    /**
//     * Gets the accounts.
//     * 
//     * @param userId
//     *            the user id
//     * @return the accounts
//     */
//    public ArrayList<Account> getAccounts(int userId) {
//        ArrayList<Account> accounts = new ArrayList<Account>();
//        String[] args = {String.valueOf(userId)};
//        Cursor c = db.rawQuery("SELECT * FROM " + ACCOUNTS_TABLE
//            + " where user_id" + "=?", args);
//        if (c != null) {
//            if (c.moveToFirst()) {
//                while (!c.isAfterLast()) {
//                    String accName = c
//                        .getString(c.getColumnIndex(ACCOUNT_NAME));
//                    String dispName = c.getString(c
//                        .getColumnIndex(DISPLAY_NAME));
//                    double bal = c.getDouble(c.getColumnIndex(BALANCE));
//                    double ir = c.getDouble(c.getColumnIndex(INTEREST_RATE));
//                    accounts.add(new Account(accName, dispName, bal, ir));
//                    c.moveToNext();
//                }
//            } else {
//                return null;
//            }
//        } else {
//            return null;
//        }
//
//        return accounts;
//
//    }
//
//    /**
//     * Gets the transactions.
//     * 
//     * @param accountId
//     *            the account id
//     * @return the transactions
//     */
//    public ArrayList<Transaction> getTransactions(int accountId) {
//        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
//        String[] args = {String.valueOf(accountId)};
//        Cursor c = db.rawQuery("SELECT * FROM Transactions where account_id"
//            + "=?", args);
//        if (c != null) {
//            if (c.moveToFirst()) {
//                while (!c.isAfterLast()) {
//                    String type = c.getString(c
//                        .getColumnIndex("transaction_type"));
//                    String name = c.getString(c
//                        .getColumnIndex("transaction_name"));
//                    double amount = c.getDouble(c.getColumnIndex("amount"));
//                    String category = c.getString(c.getColumnIndex("category"));
//                    String dateAsString = (c
//                        .getString(c.getColumnIndex("date")));
//                    SimpleDateFormat dateFormat = new SimpleDateFormat(
//                        DATE_FORMAT);
//                    java.util.Date utilDate;
//                    try {
//                        utilDate = dateFormat.parse(dateAsString);
//                        Date date = new Date(utilDate.getTime());
//                        transactions.add(new Transaction(type, name, amount,
//                            date, category));
//                    } catch (ParseException e) {
//                        // nothing now
//                    }
//
//                    c.moveToNext();
//                }
//            } else {
//                return null;
//            }
//        } else {
//            return null;
//        }
//        Collections.reverse(transactions);
//        return transactions;
//    }
//
//    /**
//     * Gets the transactions.
//     * 
//     * @param userId
//     *            the user id
//     * @param startDate
//     *            the start date
//     * @param endDate
//     *            the end date
//     * @return the transactions
//     */
//    public ArrayList<Transaction> getTransactions(int userId, String startDate,
//        String endDate) {
//        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
//        String[] args = {String.valueOf(userId), startDate, endDate};
//        Cursor c = db
//            .rawQuery(
//                "SELECT * FROM Transactions where user_id=? AND date>=? AND date<=? AND category!='Deposit'",
//                args);
//        if (c != null) {
//            if (c.moveToFirst()) {
//                while (!c.isAfterLast()) {
//                    String type = c.getString(c
//                        .getColumnIndex("transaction_type"));
//                    String name = c.getString(c
//                        .getColumnIndex("transaction_name"));
//                    double amount = c.getDouble(c.getColumnIndex("amount"));
//                    String category = c.getString(c.getColumnIndex("category"));
//                    String dateAsString = (c
//                        .getString(c.getColumnIndex("date")));
//                    SimpleDateFormat dateFormat = new SimpleDateFormat(
//                        DATE_FORMAT);
//                    java.util.Date utilDate;
//                    try {
//                        utilDate = dateFormat.parse(dateAsString);
//                        Date date = new Date(utilDate.getTime());
//                        transactions.add(new Transaction(type, name, amount,
//                            date, category));
//                    } catch (ParseException e) {
//                        // nothing now
//                    }
//
//                    c.moveToNext();
//                }
//            } else {
//                return null;
//            }
//        } else {
//            return null;
//        }
//
//        return transactions;
//    }
}
