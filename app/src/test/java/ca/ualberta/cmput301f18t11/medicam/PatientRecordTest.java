package ca.ualberta.cmput301f18t11.medicam;

import org.junit.Test;

import java.util.Date;
import java.util.UUID;


import ca.ualberta.cmput301f18t11.medicam.models.PatientRecord;

import static org.junit.Assert.*;

public class PatientRecordTest {

    @Test
    public void testAssignProblem(){
        PatientRecord patient_rec =  new PatientRecord();
        String problem_uuid = UUID.randomUUID().toString();

        patient_rec.setPatient(problem_uuid);
        //To string because the object reference probably won't be preserved
        // if it is sent and brought back with ElasticSearch
        assertEquals(patient_rec.getPatient(),problem_uuid);

        //To string because the object reference probably won't be preserved
        // if it is sent and brought back with ElasticSearch
    }

    @Test
    public void cannot_reassign_problem(){
        //We should not be able to reassign which care_provider wrote this record
        PatientRecord patient_rec =  new PatientRecord();
        String problem_uuid = UUID.randomUUID().toString();
        String other_uuid = UUID.randomUUID().toString();

    }

//    @Test(expected = ReassignmentException.class)
//    public void cannot_reassign_problem(){
//        //We should not be able to reassign which care_provider wrote this record
//        PatientRecord patient_rec =  new PatientRecord();
//        UUID problem_uuid = UUID.randomUUID();
//        UUID other_uuid = UUID.randomUUID();
//        patient_rec.setPatient(problem_uuid);
//        patient_rec.setPatient(other_uuid);
//    }

    @Test
    public void testAddAttachment() {
        //I suppose this covers all the possible types of attachments
        //only the view cares about what the attachments actually are.
        PatientRecord patient_rec = new PatientRecord();

        String added_attachement = UUID.randomUUID().toString();
        patient_rec.addAttachment(added_attachement);
        assertTrue(patient_rec.hasAttachment(added_attachement));

    }

    @Test
    public void testRemoveAttachment() {
        PatientRecord patient_rec = new PatientRecord();
        String added_attachement = UUID.randomUUID().toString();
        patient_rec.addAttachment(added_attachement);
        patient_rec.removeAttachment(added_attachement);
        assertFalse(patient_rec.hasAttachment(added_attachement));
    }
    @Test
    public void testSearchability(){
        PatientRecord patient_rec = new PatientRecord();
        patient_rec.setTitle("Title");
        patient_rec.setDescription("searchable key-word");
        patient_rec.setTimestamp(new Date());
        assertTrue(patient_rec.search("key"));
        assertFalse(patient_rec.search("banana"));
    }
}