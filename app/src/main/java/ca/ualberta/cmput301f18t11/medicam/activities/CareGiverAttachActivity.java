package ca.ualberta.cmput301f18t11.medicam.activities;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import ca.ualberta.cmput301f18t11.medicam.R;
import ca.ualberta.cmput301f18t11.medicam.activities.AddDoctorNoteActivity;
import ca.ualberta.cmput301f18t11.medicam.controllers.ElasticSearchController;
import ca.ualberta.cmput301f18t11.medicam.controllers.abstracts.PersistenceController;
import ca.ualberta.cmput301f18t11.medicam.controllers.per_model.PatientRecordPersistenceController;
import ca.ualberta.cmput301f18t11.medicam.controllers.per_model.ProblemPersistenceController;
import ca.ualberta.cmput301f18t11.medicam.models.Patient;
import ca.ualberta.cmput301f18t11.medicam.models.PatientRecord;
import ca.ualberta.cmput301f18t11.medicam.models.Problem;

public class CareGiverAttachActivity extends AppCompatActivity {
    private TextView titleView;
    private PatientRecord record;
    private PersistenceController<PatientRecord> recordController = new PatientRecordPersistenceController();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_care_giver_attach);
        ElasticSearchController.setIndex_url("cmput301f18t11test");

        titleView = findViewById(R.id.attachTitleTextView);

        Intent intent = getIntent();
        String recordUUID = intent.getStringExtra("recordUUID");
        record = recordController.load(recordUUID,this);
        titleView.setText(record.getTitle());
    }

}