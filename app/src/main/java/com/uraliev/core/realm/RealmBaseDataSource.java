package com.uraliev.core.realm;

import android.util.Log;

import io.realm.Realm;

public abstract class RealmBaseDataSource {
    //Region Private
    protected Realm getRealmInstance(){
        return Realm.getDefaultInstance();
    }
    protected void  executeTransaction(Realm.Transaction transaction){
        Realm realm = null;
        try{
            realm = getRealmInstance();
            realm.executeTransaction(transaction);
        }
        catch (Exception e){
            Log.e("ololo",e.getMessage(),e);
        }
        finally {
            if(realm != null){
                realm.close();
            }
        }
    }

    //endregion

    //Autoincrement Realm object id
    protected long getNextId(Class c){
        Realm realm = null;
        try {
            realm = getRealmInstance();
            String primaryKeyField = realm.getSchema().get(c.getSimpleName()).getPrimaryKey();
            if (realm.where(c).max(primaryKeyField)== null)
                return 1;

            long value = realm.where(c).max(primaryKeyField).longValue();

            return value + 1;
        } catch (Exception e) {
            return -1;
        } finally {
            if (realm != null) {
                realm.close();
            }
        }
    }
}
