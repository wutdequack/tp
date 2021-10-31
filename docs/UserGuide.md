# User Guide


## Introduction


{Give a product intro}

- [Duke User Guide](#duke-user-guide)
    - [Quick Start](#Quick Start)
    - [Features](#Features)
        - [Adding an elderly : `addelderly`](#adding-an-elderly-addelderly)
        - [Adding a medicine to an elderly : `addmed`](#adding-medicine-to-an-elderly-addmed)
        - [Adding an appointment to an elderly : `addappt`](#adding-appointment-to-an-elderly-addappt)
        - [Viewing medicine of an elderly : `viewmed`](#viewing-medicine-of-an-elderly-viewmed)
        - [Viewing appointments of an elderly : `viewappt`](#viewing-appointments-of-an-elderly-viewappt)
        - [Setting dietary preference `setdiet`](#set-dietary-preference-setdiet)
        - [Viewing dietary preference `viewdiet`](#view-dietary-preference-viewdiet)
        - [Setting birthday `setbirthday`](#set-birthday-setbirthday)
        - [Viewing birthday `viewbirthday`](#view-birthday-viewbirthday)
        - [Setting blood pressure`setbloodpressure`](#set-blood-pressuresetbloodpressure)
        - [Viewing blood pressure `viewbloodpressure`](#view-blood-pressure-viewbloodpressure)
        - [Setting to be vaccinated `setvaccinatd`](#set-to-be-vaccinated-setvaccinatd)
        - [View vaccination status `viewvaccination`](#view-blood-pressure-viewbloodpressure)
        - [Terminating `bye`](#terminating-bye)
    - [Table of commands](#Command Summary)
    - [Reference](#reference)

## Quick Start

{Give steps to get started quickly}

1. Ensure that you have Java 11 or above installed.
2. Download the latest version of `Duke` from [here](http://link.to/duke).
3. Copy Duke.jar to the target directory as the home folder
4. Open terminal and move current directory to the home folder
5. Run the program using `java -jar Duke.jar` command.
6. We are all done. Type your first command in terminal to talk to Duke.

## Features 

{Give detailed description of each feature}

### Adding an elderly: `addelderly`
Adds an elderly to take care of. Risk level of elderly will be asked for, followed by additional
information if needed (according to risk level)

Format: `addelderly u/USERNAME n/NAME r/RISK_LEVEL`

* The `USERNAME` only can contain characters or numbers.
* The `NAME` only can contain characters or whitespaces.
* The `RISK_LEVEL` can only be `l`, `m`, `h` which stands for
low-level risk, medium-level risk and high-level risk respectively.
* `l` risk level does not require additional information.
* `m` risk level requires `hospital`, `conditions` and `notesOnCare` information
* `h` risk level requires `hospital`, `conditions`, `notesOnCare` and `doctor` information.

Example of usage (for `h` risk level elderly):


`addelderly u/johntan123 n/John Tan r/h`

```
> addelderly u/johntan123 n/John Tan r/h
List of hospitals are shown below:
1.changi general hospital
2.khoo teck puat hospital
3.national university hospital
4.ng teng feng general hospital
5.singapore general hospital
6.tan tock seng hospital
Enter hospital number choice. (e.g. 1 for Changi General Hospital etc.)
> 2
Enter elderly condition below. Hit enter when done.
> amnesia, stage 2 liver cancer, lower body paralysis
Enter notes on care below. Hit enter when done.
> at least 3 nurses required to ensure safety when showering. needs daily routine of going on walks at 7am. remember to lock wheelchair when stationary. meals should only be given during mealtimes to prevent overconsumption. reduce salt in food. liver checks to be done every sunday 3pm.
List of khoo teck puat hospital doctors are shown below:
1.adrian vergil
2.joline dean
3.shui lorin
4.britney soh
5.aditi nitya
Enter doctor number choice. (e.g. 1)
> 1
```

### Adding medicine to an elderly: `addmed`
Adds a medicine to an existing elderly.

Format: `addmed u/USERNAME m/MEDICINE_NAME f/FREQUENCY`

* The `USERNAME`  only can contain characters or numbers.
* The `MEDICINE_NAME` cannot contain punctuation.
* The `FREQUENCY` can be in a natural language format.

Example of usage:

`addmed u/johntan123 m/paracetamol f/once a day`

### Adding appointment to an elderly: `addappt`
Adds an appointment to an existing elderly.

Format: `addappt u/USERNAME l/LOCATION d/DATE t/TIME [p/PURPOSE]`

* The `USERNAME`  only can contain characters or numbers.
* The `LOCATION` can be in a natural language format.
* The `DATE` only can contain 8 numbers, in the format DDMMYYYY.
* The `TIME` only can contain 4 numbers, in the format hhmm.
* The `PURPOSE` can be in a natural language format. Take note that this argument is optional, and
is defaulted to `general checkup` if unassigned.

Example of usage:

`addappt u/johntan123 l/khoo teck puat hospital d/02012021 t/1000`
`addappt u/johntan123 l/khoo teck puat hospital d/05032021 t/1500 p/eye checkup`

### Viewing medicine of an elderly: `viewmed`
Views all medicine of an existing elderly.

Format: `viewmed n/USERNAME`

* The `USERNAME`  only can contain characters or numbers.

Example of usage:

`viewmed u/johntan123`

### Viewing appointments of an elderly: `viewappt`
Views all appointments of an existing elderly.

Format: `viewappt u/USERNAME`

* The `USERNAME`  only can contain characters or numbers.

Example of usage:

### Terminating: `bye`
Terminates the current session.

Format: `bye`

Example of usage:

`bye`


### Set dietary preference `setdiet`

Sets the dietary preference of the given elderly

Format: `setdiet u/USER_NAME`

Example of usage:

`setdiet u/304`

Expected output:
```
Select the possible diet of the elderly
1. Halal
2. Vegetarian
3. Vegan
4. Beef free
5. Diabetes
6. No restriction
```
User input: `2`

Expected output:
```
Dietary preference of NickTan has been set to Vegetarian
```


### View dietary preference `viewdiet`

Views the dietary preference of the given elderly

Format: `setdiet u/USER_NAME`

Example of usage:

`viewdiet u/304`

Expected output:
```
NickTan is having a Vegetarian diet
```


### Set birthday `setbirthday`

Sets the birthday of the given elderly

Format: 

`setbirthday u/USER_NAME b/BIRHTDAY`

* BIRTHDAY are in the format of YYYY-MM-DD

Example of usage:

`setbirthday u/123 b/1959-10-29`

Expected output:

```
Birthday of NickTan has been set to 1959-10-29
```


### View birthday `viewbirthday`

Views the birthday of the given elderly

Format: 

`viewbirthday u/USER_NAME`

Example of usage:

`viewbirthday u/123`

Expected output:

```
Birthday of NickTan is 1959-10-29
```

### Set blood pressure`setbloodpressure`

Sets the most recently measured blood pressure of the elderly

Format: 
`setbloodpressure u/USER_NAME s/SYSTOLIC_PRESSURE d/DIATOLIC PRESSURE`

Example of usage:

`setbloodpressure u/123 s/120 d/80`

Expected output:

```
Blood pressure of NickTan has been updated to 120 80!
```

### View blood pressure `viewbloodpressure`

Views the most recently measured blood pressure of the given elderly

Format: 

`viewbloodpressure u/USER_NAME`

Example of usage:

`viewbloodpressure u/123`

Expected output:

```
Blood pressure of NickTan is now (120 80)
```

### Set to be vaccinated `setvaccinatd`

Sets the vaccination status of the given elderly to be vaccinated

Format:

`setvaccinated u/USER_NAME`

Example of usage:

`setvaccinated u/123`

Expected output:

```
We have set NickTan to be vaccinated
```

### View vaccination status `viewvaccination`

Views the vaccination status of the elderly

Format:

`viewvaccination u/USER_NAME`

Example of usage:

`viewvaccination u/123`

Expected output:

```
NickTan is currently vaccinated.
```


## FAQ


**Q**: AddMed does not seem to work? 

**A**: Our program is created for a fast user. Hence, we made the assumption that the user will only
type in small letters instead of capitalising some words. Use addmed instead.

**Q**: How do I add new hospitals and doctors?

**A**: Our program is created to keep track of elderly records, not to add hospitals and doctors.
Hence, we have made the hospitals and doctors fixed for this program, with the assumption that only
these few hospitals and doctors are available to be selected. 

Of course, you are welcome to upgrade this to make it more scalable! :D

## Command Summary

|Command|Format|
|---|---|
|Add elderly |`addelderly u/USERNAME n/NAME`|
|Add medicine |`addmed n/USERNAME m/MEDICINE_NAME f/FREQUENCY`|
|Add appointment |`addappt n/USERNAME l/LOCATION d/DATE t/TIME [p/PURPOSE]`|
|View medicine |`viewmed n/USERNAME`|
|View appointment |`viewappt n/USERNAME`|
|Set diet |`setdiet u/USER_NAME`|
|View dietary preference |`viewdiet u/USER_NAME`|
|Set birthday |`setbirthday u/USER_NAME b/BIRHTDAY`|
|View birthday |`viewbirthday u/USER_NAME`|
|Set blood pressure |`setbloodpressure u/USER_NAME s/SYSTOLIC_PRESSURE d/DIATOLIC PRESSURE`|
|View blood pressure |`viewbloodpressure u/USER_NAME`|
|Set vaccination status |`setvaccinated u/USER_NAME`|
|View vaccination status |`viewvaccination u/USER_NAME`|




## Reference
The template of the User Guide is followed by [AddressBook Level 3 (AB3) User Guide](https://se-education.org/addressbook-level3/UserGuide.html#editing-a-person--edit).

