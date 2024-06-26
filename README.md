Empower Assessment Readme

This Documentation will explain my implementation, some improvements and other addons I would have added into the project if more time was allocated.

Implementation:

So for the assessment, I followed the MVVM architecture. I added the raw file into the project and have it act as a Network Layer in the project. Then loaded it up into the repository, as well as setting up the list of beneficiaries and the individual beneficiary functions. Then two View Models were created for each Activity so that no one view model is overloaded with code and for better scalability. Then the RecyclerView Adapter class was setup, along with the two Activities with views built programmatically. The Main Activity along with the RecyclerView Adapter Class was built on one layout. I wanted to have the Main Layout used as the holding layout for the RecyclerView layout. Keeping the Layout Hierarchy intact. I also added a Text View for the account holder. I thought it was important to display the name of the Account holder for better clarity to the user.

Addons:

If I did have more time, I would have added a test case with the project. There would have been unit test for the Repo and View Model. Along with a test document to test the UI and make sure the app is working as intended. I would have also focused on both night and dark mode of the app so that both versions are available to the users.

Improvements:

Improvements that could have been done first would have been error handling for both repo and view models. Something I would have done would have been to add in a Resource Class to the project. There I can easily add it on to the classes that need them. It would have handled when a function call was successful, still loading, or that an error occurred and be able to display that error to the user. I would have improved the Details setup a bit more. Being that it was my first time programmatically setting up views (outside of Jetpack Compose, which I mainly use for my projects) in that way, Linear Layout was the quickest to setup. Like with the use of XML, I would have used Constraint Layout to build a better-looking Details page and have more ways to customize the page better for the user. The same for the Recycler View as well. The container would have looked much better with a Constraint Layout setup than a Linear Layout setup. Also the addition of Kotlin Coroutines would have been used here as well. Just about all the non related UI function would have become suspended function, and then go to the a background thread. Then bring them up to the main thread with viewModelScope. That would improve the speed of the app with heavier functions workinging outside the main thread.That would be the improvements I would have made that didn’t involve third party libraries. 
