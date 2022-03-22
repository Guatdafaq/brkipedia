# brkipedia

Android app that consumes the https://breakingbadapi.com/documentation API and implements a Clean arquitecture using MVVM pattern.

In this project you can find:

    - Clean Architecture  
    - MVVM  
    - Retrofit  
    - Room  
    - Hilt (Dagger)   
    - Kotlin
    - Coroutines
    - ConstraintLayout
    - Jetpack Navigation

Project structure:

	rickypedia/
	├── data
	  ├── local
	    ├── dao
	    ├── models
	    ├── Converters
	    └── Database
	  ├── mappers
	  ├── remote
	    ├── apis
      ├── models
      └── services
    └── repositories
	├── di (Hilt)
	├── domain
	  ├── common
	  ├── exceptions
	  ├── models
	  └── repositories (Interfaces)
	├── presentation
	  ├── adapters
	  ├── fragments
	  ├── viewmodels
	  └── MainActivity
	├── usecases
	└── BrkipediaApp