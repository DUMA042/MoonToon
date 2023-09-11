# MoonToon

MoonToon is an android application that show the use of MVVM architecture model in building Modern Android application.
It also Show the use of Dagger2 and Hilt to implement dependency Injection pattern on common libraries like Room and Workmanager.

### This application displays my Skills in the implementation of:
- Android clean architecture (MVVM)
- Know in the use **Room Library** (Implementation of CRUD)
- Know in the implementation of dependency Injection using **Dagger2 and Hilt**
- Know in the implementation of **WorkManager** for background tasks
- Know in Building of **Notification** and it's execution and management with **WorkManager**
- Know in the latest Navigation library and implementation in Jetpack Compose
- Know on **Permissions request** and **Permission Flow**.
- Use of **GIT** and **GITHUB** in development Cycle
- Finally the use of **Jetpack compose** to implement the UI


## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Screenshots](#screenshots)
- [Installation](#installation)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)
- [Acknowledgments](#acknowledgments)

## Introduction
Welcome to MoonToon, your simple and effective task management app that empowers you to stay organized and productive,no matter how busy your schedule.
MoonToon app helps you keep track of all your activities,giving you the power to **Create**,**Read**,**Update**,**Delete** and keep up with your activities.

## Features

### Key Features of MoonToon:

- **Task Management:** Create, edit, and organize your tasks with ease.

- **Intuitive Interface:** MoonToon boasts a clean and intuitive user interface, making it a breeze to add, update, or complete tasks.

- **Reminders and Due Dates:** Never miss an important deadline again as the MoonToon sends notification to remind you of upcoming activities

- **Priority System:** Mark tasks as high, medium, or low priority to focus on what matters most.

- **Notes and Attachments:** Add detailed notes to your tasks for better context and reference.

- **Dark Mode:** Enjoy MoonToon in a comfortable dark mode, reducing eye strain during late-night planning sessions.


## Screenshots

Include screenshots or images that showcase your app's user interface or functionality. You can embed images like this:

![Screenshot 1](/path/to/screenshot1.png)
![Screenshot 2](/path/to/screenshot2.png)

## Installation

Provide instructions on how to install your app. Include prerequisites, dependencies, and any specific steps needed for installation.

`//Hilt
implementation("com.google.dagger:hilt-android:2.47")
implementation 'androidx.hilt:hilt-work:1.0.0'
kapt("com.google.dagger:hilt-android-compiler:2.44") `


`//ROOM
def room_version = "2.5.2"
implementation "androidx.room:room-ktx:$room_version" `

    implementation "androidx.room:room-runtime:$room_version"
    annotationProcessor "androidx.room:room-compiler:$room_version"

    // To use Kotlin Symbol Processing (KSP)
    ksp "androidx.room:room-compiler:$room_version"


    // optional - RxJava2 support for Room
    implementation "androidx.room:room-rxjava2:$room_version"

    // optional - RxJava3 support for Room
    implementation "androidx.room:room-rxjava3:$room_version"

    // optional - Guava support for Room, including Optional and ListenableFuture
    implementation "androidx.room:room-guava:$room_version"

    
## Usage

Explain how to use your app. Provide examples, code snippets, or step-by-step guides to help users understand its functionality.

## Contributing

If you welcome contributions from others, describe how they can contribute to your project. Include guidelines for code contributions, bug reports, and feature requests.

## License

Specify the license under which your project is distributed. Include a link to the full license text if applicable. For example, if you're using the MIT License:

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.

## Acknowledgments

Give credit to individuals, libraries, or resources that have been helpful or influential in your project.

- Mention any open-source libraries or frameworks used.
- Thank contributors or collaborators who helped develop the project.
- Acknowledge any sources of inspiration or reference materials.

