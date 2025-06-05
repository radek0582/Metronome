package com.doga.game;

import static android.content.ContentValues.TAG;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AndroidInterfaceClass implements FireBaseInterface {
    FirebaseDatabase database;
    DatabaseReference myRef;
    ValueEventListener valueEventListener1;
    ValueEventListener valueEventListener2;
    ValueEventListener valueEventListener3;

    public AndroidInterfaceClass() {
        database = FirebaseDatabase.getInstance();
//        myRef = database.getReference("connection");
    }

    public ValueEventListener getValueEventListener1() {
        return valueEventListener1;
    }

    public void setValueEventListener1(DataHolderClass dataHolder, String id) {
        valueEventListener1 = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                String key = dataSnapshot.getKey();
                Log.d(TAG, "Value is: " + value + " key: " + key);

                if (value != null) {
                    dataHolder.getChanges().put(id, value);
                } else {

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        };
    }

    public void setValueEventListener1(DataHolderClass dataHolder) {
        valueEventListener1 = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                String key = dataSnapshot.getKey();
                Log.d(TAG, "Value is: " + value + " key: " + key);
//                dataHolder.setValue(value);
//                System.out.println("db value: " + dataSnapshot.child(""));
                dataHolder.getChanges().put(key, value);
                System.out.println("onCh:_" + key + "_val_" + value + "__");
                dataHolder.setChange(1);
                System.out.println("key " + key);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        };
    }

    public ValueEventListener getValueEventListener2() {
        return valueEventListener2;
    }


    public void setValueEventListener2(DataHolderClass dataHolder, String id) {
        valueEventListener2 = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                String key = dataSnapshot.getKey();
                Log.d(TAG, "Value is: " + value + " key: " + key);

                if (value != null) {
                    dataHolder.getChanges().put(id, value);
                    dataHolder.setDataChanged(true);
                } else {

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        };
    }

    public void setValueEventListener2(DataHolderClass dataHolder) {
        valueEventListener2 = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                String key = dataSnapshot.getKey();
                Log.d(TAG, "Value is: " + value + " key: " + key);
//                dataHolder.setValue(value);
//                System.out.println("db value: " + dataSnapshot.child(""));
                dataHolder.getChanges().put(key, value);
                System.out.println("onCh:_" + key + "_val_" + value + "__");
                dataHolder.setChange(1);
                System.out.println("key " + key);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        };
    }


    public ValueEventListener getValueEventListener3() {
        return valueEventListener3;
    }

    public void setValueEventListener3(ValueEventListener valueEventListener3) {
        this.valueEventListener3 = valueEventListener3;
    }

    @Override
    public void SetOnValueChangedListener1(DataHolderClass dataHolder, String id) {
        dataHolder.getChanges().put(id, "");
//        dataHolder.getSets().add(id);

        setValueEventListener1(dataHolder, id);
        myRef.addValueEventListener(valueEventListener1);

//        myRef.addValueEventListener(valueEventListener1 = new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                // This method is called once with the initial value and again
//                // whenever data at this location is updated.
//                String value = dataSnapshot.getValue(String.class);
//                String key = dataSnapshot.getKey();
//                Log.d(TAG, "Value is: " + value + " key: " + key);
//
//                if (value != null) {
//                    dataHolder.getChanges().put(id, value);
//                } else {
//
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                // Failed to read value
//                Log.w(TAG, "Failed to read value.", error.toException());
//            }
//        });
    }


    @Override
    public void SetOnValueChangedListener1(DataHolderClass dataHolder) {

        setValueEventListener1(dataHolder);
        myRef.addValueEventListener(valueEventListener1);
//        myRef.addValueEventListener(valueEventListener1 = new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                // This method is called once with the initial value and again
//                // whenever data at this location is updated.
//                String value = dataSnapshot.getValue(String.class);
//                String key = dataSnapshot.getKey();
//                Log.d(TAG, "Value is: " + value + " key: " + key);
////                dataHolder.setValue(value);
////                System.out.println("db value: " + dataSnapshot.child(""));
//                dataHolder.getChanges().put(key, value);
//                System.out.println("onCh:_" + key + "_val_" + value + "__");
//                dataHolder.setChange(1);
//                System.out.println("key " + key);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                // Failed to read value
//                Log.w(TAG, "Failed to read value.", error.toException());
//            }
//        });
    }

    @Override
    public void SetOnValueChangedListener(DataHolderClass dataHolder) {
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                String key = dataSnapshot.getKey();
                Log.d(TAG, "Value is: " + value + " key: " + key);
//                dataHolder.setValue(value);
//                System.out.println("db value: " + dataSnapshot.child(""));
                dataHolder.getChanges().put(key, value);
                System.out.println("onCh:_" + key + "_val_" + value + "__");
                dataHolder.setChange(1);
                System.out.println("key " + key);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }

    @Override
    public void SetOnValueChangedListener2(DataHolderClass dataHolder) {

        setValueEventListener2(dataHolder);
        myRef.addValueEventListener(valueEventListener2);
    }

    @Override
    public void SetOnValueChangedListener2(DataHolderClass dataHolder, String id) {
        dataHolder.getChanges().put(id, "");
//        dataHolder.getSets().add(id);

        setValueEventListener2(dataHolder, id);
        myRef.addValueEventListener(valueEventListener2);
    }

    @Override
    public void removeEventListener1() {
        myRef.removeEventListener(valueEventListener1);
    }

    @Override
    public void removeEventListener2() {
        myRef.removeEventListener(valueEventListener2);
    }

    @Override
    public void SetValueInDb(String target, String value) {
        myRef = database.getReference(target);
        myRef.setValue(value).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                System.out.println("success!!!");

            }
        });
    }

//    @Override
//    public void SetValueInDb(final DataHolderClass dataHolder, String target, String value) {
//        myRef = database.getReference(target);
//        myRef.setValue(value).addOnSuccessListener(new OnSuccessListener<Void>() {
//            @Override
//            public void onSuccess(Void unused) {
//                System.out.println("success!!!");
//                int ver = dataHolder.getVerifiedAmount();
//                dataHolder.setVerifiedAmount(ver - 1);
//            }
//        }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                System.out.println("failure!!!");
//                dataHolder.setVerifiedAmount(-1);
//            }
//        });
//    }

    @Override
    public void SetValueInDb(final DataHolderClass dataHolder, String target, String value) {
        myRef = database.getReference(target);
        myRef.setValue(value).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                System.out.println("success!!!");
                int ver = dataHolder.getVerifiedAmount();
                dataHolder.setVerifiedAmount(ver - 1);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                System.out.println("failure!!!");
                dataHolder.setVerifiedAmount(-1);
            }
        });
    }

    @Override
    public void SetValueInDb(final DataHolderClass dataHolder, String target, String value, String id) {
        if (id != null)
            dataHolder.getSets().add(id);

        myRef = database.getReference(target);
        myRef.setValue(value).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                if (id != null) {
//                    dataHolder.getFounds().put(id, "done");
                    System.out.println("success!!! " + id);
//                    dataHolder.getSets().add(id);
                    dataHolder.getSets().remove(id);

                    if (dataHolder.getSets().size() == 0)
                        dataHolder.setSettingValues(1);
                }
            }
        });
    }

    @Override
    public void setRef(String ref) {
        this.myRef = database.getReference(ref);
    }

    @Override
    public void readData(final DataHolderClass dataHolder, String reference, String data, String dataToRetrieve, String id) {
        if (id != null) {
            if (dataHolder.getMissedFounds().containsKey(id))
                dataHolder.getFounds().put(id, "notFound");
            else {
//                dataHolder.getFounds().put(id, "");
                dataHolder.getSets().add(id);
            }
        }

        if (dataHolder.getMissedData() == 0) {
            myRef = FirebaseDatabase.getInstance().getReference(reference);
            myRef.child(data).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DataSnapshot> task) {
                    if (task.isSuccessful()) {
                        String dataRetrieved;
                        DataSnapshot dataSnapshot = task.getResult();

                        if (!dataToRetrieve.equals(""))
                            dataRetrieved = String.valueOf(dataSnapshot.child(dataToRetrieve).getValue());
                        else
                            dataRetrieved = String.valueOf(dataSnapshot.child(""));

                        System.out.println("retrieved:   ....   " + dataRetrieved + " from " + id);

                        if (dataSnapshot.child(dataToRetrieve).getValue() != null) {
                            dataHolder.setValue(dataRetrieved);

                            if (id != null) {
                                dataHolder.getFounds().put(id, dataRetrieved);
                                dataHolder.getSets().remove(id);
                                int foundData = dataHolder.getFoundData() + 1;
                                dataHolder.setFoundData(foundData);
                            }

                            if (dataHolder.getSets().size() == 0)
                                dataHolder.setFound(1);

                        } else {
                            System.out.println("null zero!");
//                            dataHolder.setFound(-1);
                            dataHolder.getMissedFounds().put(id, "notFound");
                            dataHolder.getFounds().put(id, "notFound");
                        }
                        System.out.println("Founds size: " + dataHolder.getFounds().size());

                    }
                }
            });
        } else if (dataHolder.getMissedData() != 0 && dataHolder.getMissedFounds().containsKey(id)) {
            myRef = FirebaseDatabase.getInstance().getReference(reference);
            myRef.child(data).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DataSnapshot> task) {
                    if (task.isSuccessful()) {
                        String dataRetrieved;
                        DataSnapshot dataSnapshot = task.getResult();

                        if (!dataToRetrieve.equals(""))
                            dataRetrieved = String.valueOf(dataSnapshot.child(dataToRetrieve).getValue());
                        else
                            dataRetrieved = String.valueOf(dataSnapshot.child(""));

                        System.out.println("retrieved:   ....   " + dataRetrieved + " from " + id);

                        if (dataRetrieved != null && !dataRetrieved.equals("null")) {
                            dataHolder.setValue(dataRetrieved);

                            if (id != null) {
                                dataHolder.getFounds().put(id, dataRetrieved);
                                dataHolder.getSets().remove(id);
                                int foundData = dataHolder.getFoundData() + 1;
                                dataHolder.setFoundData(foundData);
                                dataHolder.getMissedFounds().remove(id);
                                int missedData = dataHolder.getMissedData() - 1;
                                dataHolder.setMissedData(missedData);

                            }

                            if (dataHolder.getSets().size() == 0)
                                dataHolder.setFound(1);
                        } else {
                            System.out.println("null zero!");
//                            dataHolder.setFound(0);
                            dataHolder.getMissedFounds().put(id, "notFound");
                            dataHolder.getFounds().put(id, "notFound");
                        }

                        System.out.println("missed received: " + dataRetrieved);
                        System.out.println(dataHolder.getFounds().get(id) + id);
                        System.out.println("Founds size: " + dataHolder.getFounds().size());
                    }
                }
            });
        }
    }

    @Override
    public void readData3(final DataHolderClass dataHolder, String reference, String data, String dataToRetrieve, String id) {
        dataHolder.setFound(-1);

        if (dataHolder.getMissedFounds().containsKey(id)) {
            myRef = FirebaseDatabase.getInstance().getReference(reference);
            myRef.child(data).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DataSnapshot> task) {
                    if (task.isSuccessful()) {
                        String dataRetrieved;
                        DataSnapshot dataSnapshot = task.getResult();
                        dataRetrieved = String.valueOf(dataSnapshot.child(dataToRetrieve).getValue());
                        System.out.println("retrieved:   ....   " + dataRetrieved + " from " + id);

                        if (dataSnapshot.child(dataToRetrieve).getValue() != null) {
                            if (dataHolder.getDataToRetrieve().containsKey(id)) {
                                dataHolder.getFounds().put(id, dataRetrieved);
                                dataHolder.getDataToRetrieve().remove(id);
                                dataHolder.getMissedFounds().remove(id);
                                System.out.println("added -> " + id + dataRetrieved);
                            }
                        } else
                            System.out.println("null zero! Still not found");
                    }
                }
            });
        } else if (!dataHolder.getFounds().containsKey(id)) {
            myRef = FirebaseDatabase.getInstance().getReference(reference);
            myRef.child(data).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DataSnapshot> task) {
                    if (task.isSuccessful()) {
                        String dataRetrieved;
                        DataSnapshot dataSnapshot = task.getResult();
                        dataRetrieved = String.valueOf(dataSnapshot.child(dataToRetrieve).getValue());
                        System.out.println("retrieved:   ....   " + dataRetrieved + " from " + id);

                        if (dataSnapshot.child(dataToRetrieve).getValue() != null) {
                            dataHolder.getFounds().put(id, dataRetrieved);
                        } else {
                            System.out.println("null zero!");
                            dataHolder.getDataToRetrieve().put(id, "toRetrieve");
                            dataHolder.getMissedFounds().put(id, "notFound");
                            dataHolder.getFounds().remove(id);
                        }

                        System.out.println("Founds size: " + dataHolder.getFounds().size());
                    }
                }
            });
        }
    }

    @Override
    public void readData4(final DataHolderClass dataHolder, String reference, String data, String dataToRetrieve, String id) {
        dataHolder.setFound(-1);

        if (dataHolder.getToSearch().containsKey(id)) {
            dataHolder.getToSearch().remove(id);

            if (dataHolder.getMissedFounds().containsKey(id)) {
                myRef = FirebaseDatabase.getInstance().getReference(reference);
                myRef.child(data).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        if (task.isSuccessful()) {
                            String dataRetrieved;
                            DataSnapshot dataSnapshot = task.getResult();
                            dataRetrieved = String.valueOf(dataSnapshot.child(dataToRetrieve).getValue());
                            System.out.println("retrieved:   ....   " + dataRetrieved + " from " + id);

                            if (dataSnapshot.child(dataToRetrieve).getValue() != null) {
                                if (dataHolder.getDataToRetrieve().containsKey(id)) {
                                    dataHolder.getFounds().put(id, dataRetrieved);
                                    dataHolder.getDataToRetrieve().remove(id);
                                    dataHolder.getMissedFounds().remove(id);
                                    System.out.println("added -> " + id + dataRetrieved);
                                }
                            } else {
                                System.out.println("null zero! Still not found");
                                dataHolder.getToSearch().put(id, "");
                            }
                        }
                    }
                });
            } else if (!dataHolder.getFounds().containsKey(id)) {
                myRef = FirebaseDatabase.getInstance().getReference(reference);
                myRef.child(data).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        if (task.isSuccessful()) {
                            String dataRetrieved;
                            DataSnapshot dataSnapshot = task.getResult();
                            dataRetrieved = String.valueOf(dataSnapshot.child(dataToRetrieve).getValue());
                            System.out.println("retrieved:   ....   " + dataRetrieved + " from " + id);

                            if (dataSnapshot.child(dataToRetrieve).getValue() != null) {
                                dataHolder.getFounds().put(id, dataRetrieved);
                            } else {
                                System.out.println("null zero!");
                                dataHolder.getDataToRetrieve().put(id, "toRetrieve");
                                dataHolder.getMissedFounds().put(id, "notFound");
                                dataHolder.getFounds().remove(id);
                                dataHolder.getToSearch().put(id, "");
                            }

                            System.out.println("Founds size: " + dataHolder.getFounds().size());
                        }
                    }
                });
            }
        }
    }


    @Override
    public void readDataNullable(final DataHolderClass dataHolder, String reference, String data, String dataToRetrieve, String id) {
//        boolean pass = true;

        if (id != null) {
//            if (!dataHolder.getFounds().containsKey(id)) {
//            dataHolder.getFounds().put(id, "");
            dataHolder.getSets().add(id);
//            }
//            else
//                pass = false;
        }

//        if (pass) {
        myRef = FirebaseDatabase.getInstance().getReference(reference);
        myRef.child(data).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (task.isSuccessful()) {
                    String dataRetrieved;
                    DataSnapshot dataSnapshot = task.getResult();

                    if (!dataToRetrieve.equals(""))
                        dataRetrieved = String.valueOf(dataSnapshot.child(dataToRetrieve).getValue());
                    else
                        dataRetrieved = String.valueOf(dataSnapshot.child(""));

                    System.out.println("retrieved:   ....   " + dataRetrieved);

                    if (dataSnapshot.child(dataToRetrieve).getValue() != null) {
                        dataHolder.setValue(dataRetrieved);
                        dataHolder.setFoundEntry(true);

                        if (id != null) {
                            dataHolder.getFounds().put(id, dataRetrieved);
                            dataHolder.getSets().remove(id);
                        } else {
//                            dataHolder.getMissedFounds().put(id, "missed");
                        }

                        if (dataHolder.getSets().size() == 0)
                            dataHolder.setFound(1);

                    } else {
                        System.out.println("null zero! Found data: key: " + dataSnapshot.child(dataToRetrieve).getValue() + " val " + dataRetrieved);
//                        dataHolder.getFounds().remove(id);
                        dataHolder.setFoundEntry(false);
                        dataHolder.setFound(1);
//                        dataHolder.getFounds().put(id, "-missedData-");
//                        dataHolder.getSets().remove(id);
//                        dataHolder.setRefresh(true);
//                        dataHolder.getFounds().clear();
//                        dataHolder.getSets().clear();
                    }
                }
            }
        });
//        }
    }


}

