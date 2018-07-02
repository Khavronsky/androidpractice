package io.mycompany.androidpractice.dialogs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import io.mycompany.androidpractice.R;
import io.mycompany.androidpractice.model.Card;
import io.mycompany.androidpractice.util.DataUtilSimple;

public class AddNewItemDialogFragment extends DialogFragment {

    private EditText textHeading;
    private EditText textDesc;
    private CheckBox checkBox;

    public AddNewItemDialogFragment() {
    }

    public static AddNewItemDialogFragment newInstance(){
        return new AddNewItemDialogFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_new_item, container, false);
        textHeading = view.findViewById(R.id.editTextHeader);
        textDesc = view.findViewById(R.id.editTextDescription);
        Button button = view.findViewById(R.id.btnAdd);
        checkBox = view.findViewById(R.id.checkBoxDialog);
        checkBox.setChecked(false);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeNewItem();
                dismiss();
            }
        });

        return view;
    }
    public void makeNewItem(){

        String heading = String.valueOf(textHeading.getText());
        String desc = String.valueOf(textDesc.getText());

        if (!heading.isEmpty() && !desc.isEmpty()) {
            DataUtilSimple.addNewItem(new Card(heading, desc, checkBox.isChecked()));
            Toast toast = Toast.makeText(getActivity(),
                    "Successful", Toast.LENGTH_SHORT);
            toast.show();
        } else {

        }
    }
}