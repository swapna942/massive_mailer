*** Settings ***
Resource          resource.robot
Suite Setup       Open Browser and Clean Database
Suite Teardown    Close All Browsers
Default Tags      contact

*** Variables ***
${email}            to_add_contact@gmail.com
${alertMessage}     Email ${email} is already exist
${successMessage}   Add contact successfully

*** Test Cases ***
Verify Add New Contact To Contact List
	Given Add A Contact    ${email}
	Then I should get an alert dialog with message  ${successMessage}
	And Page Should Contain    ${email}

Verify Add Existing Contact To Contact List
 	Given Add A Contact    ${email}
	Then I should get an alert dialog with message  ${alertMessage}
	And Page Should Contain    ${email}

*** Keyword ***
Open Browser and Clean Database
	Open Browser    ${SENDMAIL URL}    ${BROWSER}
	Delete All Contacts
