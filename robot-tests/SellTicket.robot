*** Settings ***
Library           SeleniumLibrary    15.0    5.0

Suite Setup       Open Browser    ${URL}    ${BROWSER}
Suite Teardown    Close Browser

*** Variables ***
${URL}            http://localhost:3000/
${BROWSER}        Chrome

*** Test Cases ***
View Events Test Case
    [Documentation]    Varmistetaan tapahtumien näkyminen
    Page Should Contain    14.02.2023 klo 16.00 Testitapahtuma, tapahtumapaikka1
    Page Should Contain    20.04.2023 klo 20.30 Tapahtuma 2, tapahtumapaikka2
    Page Should Contain    20.04.2023 klo 20.30 Kolmas tapahtuma toden sanoo, tapahtumapaikka1

View Tickets Test Case
    [Documentation]    Varmistetaan että tapahtuman liput (tai lippu) näkyy
    @{event_elements}=  Get WebElements  css=.event
    Click Element  ${event_elements[0]}
    Page Should Contain    Opiskelija-lippu 12.50€

Add Tickets Test Case
    [Documentation]    Lisätään kaksi opiskelija-lippua 'ostoskoriin'
    Click Button    css=.addBtn
    Input Text    css=.ticketAmount    2
    Page Should Contain    Hinta: 25.00€
    Page Should Contain    Summa 25.00€

Sell And Display Tickets Test Case
    [Documentation]    Myydään valitut liput ja tulostetaan ne näytölle
    Click Button    css=.sellBtn
    Sleep    5
    Click Button    css=.transactionTickets
    Page Should Contain    Myyntitapahtuma #3
    Page Should Contain    ID 4
    Page Should Contain    ID 5

Cancel Transaction Test Case
    [Documentation]    Poistetaan myyntitapahtuma
    Click Button    css=#cancelTransaction
    Alert Should Be Present