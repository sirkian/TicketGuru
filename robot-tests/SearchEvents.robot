*** Settings ***
Library           SeleniumLibrary    15.0    5.0

Suite Setup       Open Browser    ${URL}    ${BROWSER}
Suite Teardown    Close Browser

*** Variables ***
${URL}            http://localhost:3000/
${BROWSER}        Chrome

*** Test Cases ***
Search for Event Test Case
    [Documentation]    Testataan tapahtuman haku nimellä ja väärällä nimellä
    Input Text         name=event    Testitapahtuma
    Click Button       css=#search-btn
    Page Should Contain    14.02.2023 klo 16.00 Testitapahtuma, tapahtumapaikka1
    Clear Element Text  name=event
    Input Text         name=event    Tosisiistitapahtuma
    Click Button       css=#search-btn
    Page Should Contain    Tapahtumia ei löytynyt
    

