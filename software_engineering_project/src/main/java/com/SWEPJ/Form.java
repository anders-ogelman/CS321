package com.SWEPJ;

//PID = pid of requester
//DOB = date of birth of the requester
//name fields = name of the requester
//email = email of the requester
//relation = requesters relation to the dead
//DOD = date of death
//relatedPID = the relitives pid
//fid = id to look form up with
//fail = [PID, DOB, relation, firstname, middlename, lastname, email, relatedPID, DOD] * FID is managed internally by database manager and does not need checked here
public class Form {
    private Boolean fail[];
    private long PID, relatedPID, FID;
    private String DOB, DOD, firstName, middleName, lastName, email, relation;

    public Form(long PID, String DOB, String DOD, String relation, String firstName, String middleName,
            String lastName, String email, long relatedPID) {
        this.PID = PID;
        this.DOB = DOB;
        this.DOD = DOD;
        this.relation = relation;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.email = email;
        this.relatedPID = relatedPID;
        this.FID = -1;
        fail = new Boolean[9];
        for (int i = 0; i < 9; i++)
            fail[i] = false; // PID DOB relation firstName middleName lastName email
        isValid();// Will require user classes to manually check fail[] array
    }

    public String getDOD() {
        return DOD;
    }

    public long getRelatedPID() {
        return relatedPID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public long getPID() {
        return PID;
    }

    public String getRelation() {
        return relation;
    }

    public String getDOB() {
        return DOB;
    }

    public String getEmail() {
        return email;
    }

    public long getFID() {
        return FID;
    }

    public Boolean[] getFail() {
        return fail;
    }

    public void setFID(long FID) {
        this.FID = FID;
    }

    public Boolean setDOB(String DOB) {
        String temp = this.DOB;
        this.DOB = DOB;
        if (isValid())
            return true;
        this.DOB = temp;
        return false;
    }

    public Boolean setFirstName(String firstName) {
        String temp = this.firstName;
        this.firstName = firstName;
        if (isValid())
            return true;
        this.firstName = temp;
        return false;
    }

    public Boolean setLastName(String lastName) {
        String temp = this.lastName;
        this.lastName = lastName;
        if (isValid())
            return true;
        this.lastName = temp;
        return false;
    }

    public Boolean setDOD(String DOD1) {
        String temp = this.DOD;
        this.DOD = DOD1;
        if (isValid())
            return true;
        this.DOD = temp;
        return false;
    }

    public Boolean setMiddleName(String middleName) {
        String temp = this.middleName;
        this.middleName = middleName;
        if (isValid())
            return true;
        this.middleName = temp;
        return false;
    }

    public Boolean setPID(long PID) {
        long temp = this.PID;
        this.PID = PID;
        if (isValid())
            return true;
        this.PID = temp;
        return false;
    }

    public Boolean setRelatedPID(long relatedPID) {
        long temp = this.relatedPID;
        this.relatedPID = relatedPID;
        if (isValid())
            return true;
        this.relatedPID = temp;
        return false;
    }

    public Boolean setRelation(String relation) {
        String temp = this.relation;
        this.relation = relation;
        if (isValid())
            return true;
        this.relation = temp;
        return false;
    }

    public boolean setEmail(String email) {
        String temp = this.email;
        this.email = email;
        if (isValid())
            return true;
        this.email = temp;
        return false;
    }

    // WIP
    public Boolean isValid() {
        // reset fail array
        for (int i = 0; i < 9; i++)
            fail[i] = false;

        // checks for PID
        if (String.valueOf(PID).length() != 9) {
            fail[0] = true;
        }

        if (String.valueOf(relatedPID).length() != 9) {
            fail[7] = true;
        }

        // checks for DOB
        try {
            String[] birthdate = DOB.split("/", 3);
            int month = Integer.parseInt(birthdate[0]);
            int day = Integer.parseInt(birthdate[1]);
            int year = Integer.parseInt(birthdate[2]);

            switch (month) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    if (day > 31 || day < 1)
                        fail[1] = true;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    if (day > 30 || day < 1)
                        fail[1] = true;
                    break;
                case 2:
                    if (year % 4 == 0) {
                        if (day > 29 || day < 1)
                            fail[1] = true;
                    } else {
                        if (day > 28 || day < 1)
                            fail[1] = true;
                    }
                    break;
                default:
                    fail[1] = true;
                    break;
            }
            if (year < 1900 || year > 2024)
                fail[1] = true;

        } catch (Exception e) {
            fail[1] = true;
        }

        // checks for relation
        if (relation.length() > 35 || relation.length() < 1)
            fail[2] = true;

        // checks for firstName
        if (firstName.length() > 35 || firstName.length() < 1)
            fail[3] = true;

        // checks for middleName
        if (middleName.length() > 35)
            fail[4] = true;

        // checks for lastName
        if (lastName.length() > 35 || lastName.length() < 1)
            fail[5] = true;

        try {
            String[] deathdate = DOD.split("/", 3);
            int dMonth = Integer.parseInt(deathdate[0]);
            int dDay = Integer.parseInt(deathdate[1]);
            int dYear = Integer.parseInt(deathdate[2]);

            switch (dMonth) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    // System.out.println("Working");
                    if (dDay > 31 || dDay < 1) {
                        System.out.println("day is wrong");
                        fail[8] = true;
                        System.out.println(fail[8]);
                    }
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    if (dDay > 30 || dDay < 1)
                        fail[8] = true;
                    break;
                case 2:
                    if (dYear % 4 == 0) {
                        if (dDay > 29 || dDay < 1)
                            fail[8] = true;
                    } else {
                        if (dDay > 28 || dDay < 1)
                            fail[8] = true;
                    }
                    break;
                default:
                    fail[8] = true;
                    break;
            }
            if (dYear < 1900 || dYear > 2024)
                fail[8] = true;

        } catch (Exception e) {
            fail[8] = true;
        }

        if (email.length() > 105 || email.length() < 5) {
            fail[6] = true;
        }
        try {
            String[] tester = email.split("@");
            if (tester[1].indexOf('.') == -1) {
                fail[6] = true;
            }
        } catch (Exception e) {
            fail[6] = true;
        }
        // check if any field failed
        for (int i = 0; i < 9; i++) {
            if (fail[i] == true)
                return false;
        }
        return true;
    }

}
