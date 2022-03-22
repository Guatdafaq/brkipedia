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
	
## Improvements

 - Add SplashScreen while loading data
 - Add Presentation Models instead of using Domain Models in Presentation layer
 - Dettach every framework class and add it through dependency injection
 - Save images in base64 
 - Add a Search bar for Characters
 - Add a Search bar for Quotes
 - Add testing
 - Add use of Flow
 - Update interface for using Material3 components 
 - Update interface for using Material3 themes
 - Update interface for using MotionLayouts and add animations

