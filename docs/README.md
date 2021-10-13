# Elderly in your Hood

## Features

### Storing of elderly details

Allows the user (you!!) to store information about an elderly into the
given application. Information includes: medical appointments, medicine, records, etc.
(View Usage for more details)

### Viewing of elderly details

With information about each elderly being added into the application, you can proceed
to view them now.

## Usage

### `addelderly` - Adds an elderly into the application

The given elderly username will be added. Username is used in the case
where some elderly may have the same name. The elderly will get to choose
his username. 

Example of usage:

`addelderly n/johntan123`

Expected outcome:

Elderly added message will be shown. 

```
Elderly has been added!
```

### `addmed` - Adds a medicine to an elderly

The medicine name and its frequency to be taken will be added to the elderly's
given username. 

Example of usage:

`addmed n/johntan123 m/paracetamol f/once a day`

Expected outcome:

Medicine added message will be shown.

```
Medicine has been added!
```

### `viewmed` - Views medicine required by the elderly

The medicine name and its frequency to be taken for all medicine allocated to
that elderly will be shown by the application. 

Example of usage:

`viewmed n/johntan123`

Expected outcome:

List of all medicine allocated to that elderly will be shown.

```
Medicine of johntan123 are shown below:
  1.Medicine Name: paracetemol, Frequency: once a day
```

### `addappt` - Adds an appointment to an elderly

Details of the elderly's appointment will be added to the application.
Specifically, the details are location, date, time and purpose. 
Purpose is an optional parameter that defaults to `general checkup` if
not specified by user.

Example of usage:

`addappt n/johntan123 l/khoo teck puat hospital d/02012021 t/1000`
`addappt n/johntan123 l/khoo teck puat hospital d/05032021 t/1500 p/eye checkup`

Expected outcome:

Appointment added message will be shown.

```
Appointment has been added!
```

### `viewappt` - Views upcoming appointments that the elderly has

Appointment details for all appointments of the given elderly will be shown by the application. 

Example of usage:

`viewappt n/johntan123`

Expected outcome:

List of all appointment allocated to that elderly will be shown.

```
Appointments of johntan123 are shown below:
  1.Location: khoo teck puat hospital, Date: 02012021, Time: 1000, Purpose of Visit: general checkup
  2.Location: khoo teck puat hospital, Date: 05032021, Time: 1500, Purpose of Visit: eye checkup
```

### `bye` - Terminates the application

Application will be terminated

Example of usage:

`bye`

Expected outcome:

Bye message will be printed out.

```
Bye command has been recognized. Goodbye!
```

Useful links:
* [User Guide](UserGuide.md)
* [Developer Guide](DeveloperGuide.md)
* [About Us](AboutUs.md)
