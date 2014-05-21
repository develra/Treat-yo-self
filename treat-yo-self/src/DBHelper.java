import android.content.Context;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

// TODO: Auto-generated Javadoc
/**
 * The Class DBHelper.
 */
public class DBHelper extends SQLiteOpenHelper {

    /** The Constant CREATE_TABLE_USERS. */
    private static final String CREATE_TABLE_USERS = "create table Users"
        + "(_id integer primary key, username text unique, password text not null);";

    /** The Constant CREATE_TABLE_ACCOUNTS. */
    private static final String CREATE_TABLE_ACCOUNTS = "create table Accounts"
        + "(_id integer primary key, user_id integer, account_name text unique, display_name text unique, "
        + "balance real not null, interest_rate real not null, foreign key(user_id) references Users(_id));";

    /** The Constant CREATE_TABLE_TRANSACTIONS. */
    private static final String CREATE_TABLE_TRANSACTIONS = "create table Transactions"
        + "(account_id integer, user_id integer, transaction_type text, transaction_name text, amount real not null, date integer, category text, foreign key(account_id) references Accounts(_id), foreign key(user_id) references Accounts(user_id));";

    /**
     * Instantiates a new DB helper.
     * 
     * @param context
     *            the context
     */
    public DBHelper(Context context) {
        super(context, "EverGreen", null, 1);
    }

	/* (non-Javadoc)
	 * @see android.database.sqlite.SQLiteOpenHelper#onCreate(android.database.sqlite.SQLiteDatabase)
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("PRAGMA foreign_keys=ON;");
		db.execSQL(CREATE_TABLE_USERS);
		db.execSQL(CREATE_TABLE_ACCOUNTS);
		db.execSQL(CREATE_TABLE_TRANSACTIONS);
		db.execSQL("INSERT INTO " + "Users" + " Values(1,'admin','pass123');");
		
	}

    

    /*
     * (non-Javadoc)
     * 
     * @see
     * android.database.sqlite.SQLiteOpenHelper#onUpgrade(android.database.sqlite
     * .SQLiteDatabase, int, int)
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
