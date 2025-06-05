package com.doga.game;

public interface FireBaseInterface {

//    public void SetOnValueChangedListener(DataHolderClass dataHolderClass, String id);

//    public void SetOnValueChangedListener(DataHolderClass dataHolderClass);

//    void removeEventListener (DataHolderClass dataHolder);

//    void SetOnValueChangedListener(DataHolderClass dataHolder, String id, ValueEventListener valueEventListener);

//    void SetOnValueChangedListener(DataHolderClass dataHolder, ValueEventListener valueEventListener);

//    void removeEventListener();

//    void SetOnValueChangedListener(DataHolderClass dataHolder, String id);

    void SetOnValueChangedListener(DataHolderClass dataHolder);

    void SetOnValueChangedListener1(DataHolderClass dataHolder);

    void SetOnValueChangedListener2(DataHolderClass dataHolder);

    void SetOnValueChangedListener1(DataHolderClass dataHolder, String id);

    void SetOnValueChangedListener2(DataHolderClass dataHolder, String id);

//    void removeEventListener(ValueEventListener valueEventListener);

//    void removeEventListener1(ValueEventListener valueEventListener);

//    void removeEventListener2(ValueEventListener valueEventListener);

    void removeEventListener1();

    void removeEventListener2();

    public void SetValueInDb (String target, String value);

    void SetValueInDb(DataHolderClass dataHolder, String target, String value);

    public void SetValueInDb (DataHolderClass dataHolderClass, String target, String value, String id);

    public void setRef(String ref);

    public void readData (DataHolderClass dataHolderClass, String reference, String data, String dataToRetrieve, String id);

    public void readData3 (DataHolderClass dataHolderClass, String reference, String data, String dataToRetrieve, String id);

    void readData4(DataHolderClass dataHolder, String reference, String data, String dataToRetrieve, String id);

    public void readDataNullable (DataHolderClass dataHolderClass, String reference, String data, String dataToRetrieve, String id);
}
