package ca.ualberta.cmput301f18t11.medicam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CareGiverAttachActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_care_giver_attach);


    }

    public void goAddDoctorNote(View view){
        Intent intent = new Intent(this,AddDoctorNoteActivity.class);
        startActivity(intent);
    }
}