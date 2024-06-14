# Happy today

User is presented with a list of pre-defined choices,
and can select one or more of them. The user can also add a custom choice. The user can then submit
the choices, which will be displayed in the home screen.

# Architecture

This will use a simple MVI architecture, with the following components:

- ViewModel: Provides the data (list of choices) and the selection state to the ui. Also responsible
- for capturing and storing the user's choices.
- The data is fetched and stored via a repository.
- View: A simple compose ui that displays the choices and allows the user to select them.
- Intent: The actions that the user can take

# Home screen

The home screen will display the choices that the user has made.
The choices will be displayed in a Grid view with 3 columns.

The choices will be stored locally using Room.
When the app is initialized a list of choices will be loaded from a network source and stored in
the Room database. The choices will be displayed in the home screen.

# Navigation

Navigation will be done with Compose Navigation using the bottom bar scaffold.

# TODOs

// Other alignment is a bit off
//TODO the selection colors for bottom menu can be defined in the theme

# Assumptions

After adding a "other" thing, deselecting it does not remove it. It remains in the list of choices.
