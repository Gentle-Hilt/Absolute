# About

- How to work with realtime-database(RTDB)?
- How to work with cloud-messaging(FCM)? 
- How to modify and use other libraries in all my future projects?
- How to make realtime-database typesafe? 
- How to make multi-module project without copy pasting dependencies? 
- How to make compose code readable without having infinite amount of (Rows and Columns)/(modifiers)?
- How to reduce the amount of xml files in code to minimum?

#### Keeping all those questions in mind, I started working on my new pet-project.
To learn both FCM and RTDB, I decided to connect them and update my compose-ui on received notifications. It worked flawlessly because FCM worked on a much lower level than I initially thought.\
With kotlin-reflect i achieved typesafe connection with RTDB more in [server_driven_ui/logic](https://github.com/Gentle-Hilt/Absolute/tree/master/server_driven_ui/src/main/java/gentle/hilt/server_driven_ui/logic).\
To reduce the amount of dependencies the best thing that i discovered was build-logic from [nowinandroid](https://github.com/android/nowinandroid/tree/main/build-logic), to see more check [build-logic](https://github.com/Gentle-Hilt/Absolute/tree/master/build-logic/convention/src/main/kotlin).\
I discovered constraint-compose, and it reduced my UI complexity, making my code much more readable and manageable because of fewer modifiers. I started to use Column/Row/Boxes with weight modifiers only to create small pieces of UI and at the end connect them with constraint layout.\
To reduce the amount of xml files i managed the [strings](https://github.com/Gentle-Hilt/Absolute/tree/master/data/src/main/java/gentle/hilt/data/res/strings) the same way as i did with [themes](https://github.com/Gentle-Hilt/Absolute/tree/master/data/src/main/java/gentle/hilt/data/res/themes), the same goes for [icons](https://github.com/Gentle-Hilt/Absolute/tree/master/data/src/main/java/gentle/hilt/data/res/drawables), i could just simply redraw them using [Compose-Canvas](https://developer.android.com/jetpack/compose/graphics/draw/overview).\
And finally thanks to [voyager](https://github.com/adrielcafe) for navigation library, I learned a lot more than I originally expected by modifying and publishing it as fork.(from multi-platform projects structure and automation to recreation of ViewModel(ScreenModel), though I did not use ScreenModel in this project)

### Samples
<html>
<table>
<thead>
<tr>
<th>Update</th>
<th>Secret</th>
<th>Promotion</th>
<th>Silent</th>
</tr>
</thead>
<tbody>
<tr>
<td><img src="https://github.com/Gentle-Hilt/Absolute/assets/108177469/642d7705-62dd-41c6-8506-9c70a08173e9" width="300" height="600"/>
<td><img src="https://github.com/Gentle-Hilt/Absolute/assets/108177469/e53a2862-09d7-4d08-91ec-5ad3d001d72b" width="300" height="600"/>
<td><img src="https://github.com/Gentle-Hilt/Absolute/assets/108177469/8aca16ac-9762-4e38-a921-6ac394a53fb4" width="300" height="600"/>
<td><img src="https://github.com/Gentle-Hilt/Absolute/assets/108177469/7741827c-ea6b-4284-8169-d4a03b6e4d57" width="300" height="600"/>
</tr>
</tbody>
</table>

## Screenshots
![App Screenshots](https://cdn.discordapp.com/attachments/841644670589206538/1187764422542897242/applicatonForReadMeDarkModeThemeDefault_.webp?ex=659812d1&is=65859dd1&hm=67fa9b40610a01196717c13ad7628ed04bd2b182605b962edc2f6e6d7ec1f03a&)

## Features
- Support configuration changes, even modified library to save backstack history for tabs in such cases, though I locked app in portrait mode. 
- Different notifications types with updating ui functionality.
- Cashing everything using room.
- 3 Different themes with Light/Dark mode support
- Authentication with Firebase Ui

  ## Google Play
- [Download](https://play.google.com/store/apps/details?id=gentle.hilt.absolute)
