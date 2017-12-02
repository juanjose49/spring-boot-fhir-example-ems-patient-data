# Project Catalog - EMS Patient Data
Team Name: FHIR I/O

Project Name: EMS Patient Data

Team Members:
1. Bryce Montano - bmontano6
1. Juan San Emeterio - jjse3
1. Haixia Shang - hshang7
1. Yu Wang - ywang3134
1. Smitha George - sgeorge65

GitHub link: https://github.gatech.edu/gt-hit-fall2017/EMS-Patient-Data

## Table of Contents
* [1.0 - Final Delivery](#10---final-delivery)
    * [1.1 - media](#11---media)
    * [1.2 - Manual - FHIR IO.pdf](#12---manual---fhir-iopdf)
    * [1.3 - Manual-FHIR IO.md](#13---manual-fhir-iomd)
* [2.0 - fhir-ems-service](#20---fhir-ems-service)
    * [2.1 - src](#21---src)
        * [2.1.1 - main](#211---main)
            * [2.1.1.1 - java/com/fhirio/fhiremsservice](#2111---javacomfhiriofhiremsservice)
                * [2.1.1.1.1 - controller](#21111---controller)
                    * [2.1.1.1.1.1 - AuthenticationController.java](#211111---authenticationcontrollerjava)
                    * [2.1.1.1.1.2 - EmergencyController.java](#211112---emergencycontrollerjava)
                    * [2.1.1.1.1.3 - FhirController.java](#211113---fhircontrollerjava)
                    * [2.1.1.1.1.4 - OrganizationController.java](#211114---organizationcontrollerjava)
                    * [2.1.1.1.1.5 - PatientController.java](#211115---patientcontrollerjava)
                    * [2.1.1.1.1.6 - UserController.java](#211116---usercontrollerjava)
                * [2.1.1.1.2 - domain](#21112---domain)
                    * [2.1.1.1.2.1 - Address.java](#211121---addressjava)
                    * [2.1.1.1.2.2 - Authentication.java](#211122---authenticationjava)
                    * [2.1.1.1.2.3 - Condition.java](#211123---conditionjava)
                    * [2.1.1.1.2.4 - Conditions.java](#211124---conditionsjava)
                    * [2.1.1.1.2.5 - Emergency.java](#211125---emergencyjava)
                    * [2.1.1.1.2.6 - EmergencyState.java](#211126---emergencystatejava)
                    * [2.1.1.1.2.7 - Measurement.java](#211127---measurementjava)
                    * [2.1.1.1.2.8 - Medication.java](#211128---medicationjava)
                    * [2.1.1.1.2.9 - Medications.java](#211129---medicationsjava)
                    * [2.1.1.1.2.10 - Note.java](#2111210---notejava)
                    * [2.1.1.1.2.11 - Organization.java](#2111211---organizationjava)
                    * [2.1.1.1.2.12 - Patient.java](#2111212---patientjava)
                    * [2.1.1.1.2.13 - Token.java](#2111213---tokenjava)
                    * [2.1.1.1.2.14 - User.java](#2111214---userjava)
                * [2.1.1.1.3 - service](#21113---service)
                    * [2.1.1.1.3.1 - AuthenticationService.java](#211131---authenticationservicejava)
                    * [2.1.1.1.3.2 - EmergencyService.java](#211132---emergencyservicejava)
                    * [2.1.1.1.3.3 - OrganizationService.java](#211133---organizationservicejava)
                    * [2.1.1.1.3.4 - PatientService.java](#211134---patientservicejava)
                    * [2.1.1.1.3.5 - UserService.java](#211135---userservicejava)
                    * [2.1.1.1.3.6 - UuidService.java](#211136---uuidservicejava)
                * [2.1.1.1.4 - FhirClient.java](#21114---fhirclientjava)
                * [2.1.1.1.5 - FhirEmsServiceApplication.java](#21115---fhiremsserviceapplicationjava)
            * [2.1.1.2 - resources](#2112---resources)
                * [2.1.1.2.1 - application.properties](#21121---applicationproperties)
                * [2.1.1.2.2 - static](#21122---static)
                    * [2.1.1.2.2.1 - css](#211221---css)
                        * [2.1.1.2.2.1.1 - login.css](#2112211---logincss)
                    * [2.1.1.2.2.2 - js](#211222---js)
                        * [2.1.1.2.2.2.1 - NewOrganizationalUser.js](#2112221---Neworganizationaluserjs)
                        * [2.1.1.2.2.2.2 - dashboard.js](#2112222---dashboardjs)
                        * [2.1.1.2.2.2.3 - emergency.js](#2112223---emergencyjs)
                        * [2.1.1.2.2.2.4 - login.js](#2112224---loginjs)
                        * [2.1.1.2.2.2.5 - newemergency.js](#2112225---newemergencyjs)
                        * [2.1.1.2.2.2.6 - newuser.js](#2112226---newuserjs)
                        * [2.1.1.2.2.2.7 - patientdetails.js](#2112227---patientdetailsjs)
                    * [2.1.1.2.2.3 - dashboard.html](#211223---dashboardhtml)
                    * [2.1.1.2.2.4 - emergency.html](#211224---emergencyhtml)
                    * [2.1.1.2.2.5 - index.html](#211225---indexhtml)
                    * [2.1.1.2.2.6 - newOrganizationalUser.html](#211226---neworganizationaluserhtml)
                    * [2.1.1.2.2.7 - newemergency.html](#211227---newemergencyhtml)
                    * [2.1.1.2.2.8 - newuser.html](#211228---newuserhtml)
                    * [2.1.1.2.2.9 - patientdetails.html](#211229---patientdetailshtml)
        * [2.1.2 - test/java/com/fhirio/fhiremsservice](#212---testjavacomfhiriofhiremsservice)
            * [2.1.2.1 - FhirEmsServiceApplicationTests.java](#2121---fhiremsserviceapplicationTestsjava)
            * [2.1.2.2 - service](#2122---service)
                * [2.1.2.2.1 - AuthenticationServiceTest.java](#21221---authenticationserviceTestjava)
                * [2.1.2.2.2 - EmergencyServiceTest.java](#21222---emergencyserviceTestjava)
                * [2.1.2.2.3 - OrganizationServiceTest.java](#21223---organizationserviceTestjava)
                * [2.1.2.2.4 - PatientServiceTest.java](#21224---patientserviceTestjava)
                * [2.1.2.2.5 - PatientUpdateTest.java](#21225---patientupdateTestjava)
                * [2.1.2.2.6 - UserServiceTest.java](#21226---userserviceTestjava)
    * [2.2 - .gitignore](#22---gitignore)
    * [2.3 - Dockerfile](#23---dockerfile)
    * [2.4 - pom.xml](#24---pomxml)
* [3.0 - docker-compose.yml](#30---docker-composeyml)

## 1.0 - Final Delivery
This is the top-level directory that contains all our documentation for Deliverables 4/5.
### 1.1 - media
This directory contains all the images used in our documentation.
### 1.2 - Manual - FHIR IO.pdf
This is the PDF version of our manual, which contains instructions on how to make use of all the features our application was built to support.
### 1.3 - Manual-FHIR IO.md
This is the markdown version of our manual, which contains instructions on how to make use of all the features our application was built to support.
## 2.0 - fhir-ems-service
This is the top-level directory that holds all the source code, dependency management, git files.
### 2.1 - src
This directory holds all of the source code including Java backend service code, front-end code, and unit tests.
### 2.1.1 - main
This directory contains the Java backend service code and front-end code (html/js/css).
### 2.1.1.1 - java/com/fhirio/fhiremsservice
This directory contains the Java backend service code.
### 2.1.1.1.1 - controller
This directory holds all the REST controllers that expose our services.
### 2.1.1.1.1.1 - AuthenticationController.java
This is a REST controller used to expose our AuthenticationService in a RESTful fashion.
### 2.1.1.1.1.2 - EmergencyController.java
This is a REST controller used to expose our EmergencyService in a RESTful fashion.
### 2.1.1.1.1.3 - FhirController.java
This is a REST controller used to expose our FhirClient in a RESTful fashion.
### 2.1.1.1.1.4 - OrganizationController.java
This is a REST controller used to expose our OrganizationService in a RESTful fashion.
### 2.1.1.1.1.5 - PatientController.java
This is a REST controller used to expose our PatientService in a RESTful fashion.
### 2.1.1.1.1.6 - UserController.java
This is a REST controller used to expose our UserService in a RESTful fashion.
### 2.1.1.1.2 - domain
This directory holds all the POJOs used by our application to transfer data across the network and within our application.
### 2.1.1.1.2.1 - Address.java
This is a POJO that holds onto a Patient's address information including street address, city, state, and zip code.
### 2.1.1.1.2.2 - Authentication.java
This is a POJO that holds a User's credentials and is used primarily by the AuthenticationService to verify a user's authenticity.
### 2.1.1.1.2.3 - Condition.java
This is a POJO that holds a patient's chronic illness information, includes clinical status, verification status, name, system, code, onset date, ect.
### 2.1.1.1.2.4 - Conditions.java
This is a POJO that holds a list of patient conditions.
### 2.1.1.1.2.5 - Emergency.java
This is a POJO that holds all the pertinent information to a specific emergency that may be pending, active or closed. 
### 2.1.1.1.2.6 - EmergencyState.java
This is a POJO that holds possible status of an emergency, including pending, closed and active.
### 2.1.1.1.2.7 - Measurement.java
This is a POJO that holds measurement of a patient including measurement Uuid, name, system, value code, description,value.
### 2.1.1.1.2.8 - Medication.java
This is a POJO that holds the medication information related to a patient involved in an emergency.
### 2.1.1.1.2.9 - Medications.java
This is a POJO that holds a list of patient medications.
### 2.1.1.1.2.11 - Organization.java
This is a POJO that binds together users of the EMS service and Emergencies.
### 2.1.1.1.2.12 - Patient.java
This is a POJO that hold all the health information related to a patient involved in an emergency, including patient profile, address, and patient notes.
### 2.1.1.1.2.13 - Token.java
This is a POJO that system uses to assign token for patient and organization.
### 2.1.1.1.2.14 - User.java
This ia a POJO that holds specific user of the application that may be emergency personnel or call center personnel.
### 2.1.1.1.3 - service
This directory contains the Java backend service code.
### 2.1.1.1.3.1 - AuthenticationService.java
This is a POJO that holds users's anthemtication, and is used to verify the user by username and password.
### 2.1.1.1.3.2 - EmergencyService.java
This is a POJO that initializes the emergency service, gets an emergency by Uuid, saves an emergency pbject to memory, assigns a Uuid to it, and identify patient.
### 2.1.1.1.3.3 - OrganizationService.java
This is a POJO that constructs an organization service, gets an organization by its Uuid, saves/updates/creates an organization,adds organization user, and add emergency to the organization.
### 2.1.1.1.3.4 - PatientService.java
This is a POJO that get patient by Uuid, name, and get/update information of patients, including patient's condition, medication, patient notes.
### 2.1.1.1.3.5 - UserService.java
This is a POJO that provides sevice related to a user, including create new super user, new organizational user, save user, etc.
### 2.1.1.1.3.6 - UuidService.java
This is a POJO that radomly generate Uuid  by the system and assign to an object when is required.
### 2.1.1.1.4 - FhirClient.java
This is a POJO that provides client service for the application, including getting patient list from the server, getting detailed medical information of a patient from the server.
### 2.1.1.1.5 - FhirEmsServiceApplication.java
This is the main class of the application. Run this file will set up the application.
### 2.1.1.2 - resources
This directory contains the front-end code (html/js/css) and application.properties file, which is used to configure aspects of the Java application.
### 2.1.1.2.1 - application.properties
This is properties file for the application.
### 2.1.1.2.2 - static
This directory contains all the html/js/css code.
### 2.1.1.2.2.1 - css
This directory contains the css file for the web pages.
### 2.1.1.2.2.1.1 - login.css
This is the css format file for log in page.
### 2.1.1.2.2.2 - js
This directory contains all javascript files for the HTML web pages.
### 2.1.1.2.2.2.1 - NewOrganizationalUser.js
This is the javascript file for creating a new organizational user by a super user. New user's infro will be post to the backend database.
### 2.1.1.2.2.2.2 - dashboard.js
This is the javascript file for the emergency dashboard. Emergencies with different status(pending/active/closed) will ge get from the backend.
### 2.1.1.2.2.2.3 - emergency.js
This is the javascript file to get details of an emergency from the backend. 
### 2.1.1.2.2.2.4 - login.js
This is the javascript file to authenticate user to login.
### 2.1.1.2.2.2.5 - newemergency.js
This is the javascript file for creating a new emergency, and post it to the backend .
### 2.1.1.2.2.2.6 - newuser.js
This is the javascript file for creating a new super user.
### 2.1.1.2.2.2.7 - patientdetails.js
This is the javascript file for collecting and showing detailed information of a patient, including profile, medications,etc.
### 2.1.1.2.2.3 - dashboard.html
This is the webpage for viewing emergencies in a organzation. The details of each emergency can be shown, and the status of an emergency can be updated by user.
### 2.1.1.2.2.4 - emergency.html
This is the webpage contains details of an emergency and possible patients invlolved in the emergency.
### 2.1.1.2.2.5 - index.html
This is the webpage for user to log in, or new user to register.
### 2.1.1.2.2.6 - newOrganizationalUser.html
This is the webpage for super user to enroll an new organizationl user. Username and password are required to be filled in. 
### 2.1.1.2.2.7 - newemergency.html
This is the webpage for user to fill information of a new emergency. Such as patient name and picking up location.
### 2.1.1.2.2.8 - newuser.html
This is the webpage for user to fill information to register. Such as user's name, password, organization name.
### 2.1.1.2.2.9 - patientdetails.html
This is the webpage showing detailed information of the patient. User can also add patient's note from this page. 
### 2.1.2 - test/java/com/fhirio/fhiremsservice
This directory contains all the testing files for the application.
### 2.1.2.1 - FhirEmsServiceApplicationTests.java
### 2.1.2.2 - service
This directory contains the testing files for the services.
### 2.1.2.2.1 - AuthenticationServiceTest.java
This is the testing file to test if a user's authentication is valid, including test on username and passowrd.
### 2.1.2.2.2 - EmergencyServiceTest.java
This is the testing file to test if a emergency's Uuid is valid, giing a set of emergencies.
### 2.1.2.2.3 - OrganizationServiceTest.java
This is the testing file to test if an organization is exitted by checking its Uuid.
### 2.1.2.2.4 - PatientServiceTest.java
This is the testing file to test if a patient is available, giving patient's Uuid and name.
### 2.1.2.2.5 - PatientUpdateTest.java
This is the testing file to test if patient's name, medications, conditions can be get, and if new patient can be added to te database.
### 2.1.2.2.6 - UserServiceTest.java
This is the testing file to test if the user service can get the user by user's Uuid.
### 2.2 - .gitignore
This is the file for Git to determine which files and directories to ignore. 
### 2.3 - Dockerfile
This is the docker directory that holds required docker file for the application.
### 2.4 - pom.xml
This is the XML file that contains information about the project and configuration details used by Maven to build the project.
## 3.0 - docker-compose.yml
This is the docker file that used to build and run docker for the application.
