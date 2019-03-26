package reen.com.databaseapp;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface Accountdao {

    @Query("select*from accounts")
    List<Account>getallaccounts();

    @Query("select *from accounts where accnumber=:accnumber")
    Account getoneaccountO(String accnumber);

    @Query("delete from accounts where accnumber=:accnumber")
    void deleteaccount(String accnumber);

    @Insert
    void insertaccount(Account X);

    @Update
    void updateaccount(Account Z);

    @Delete
    void delete(Account k);
}


