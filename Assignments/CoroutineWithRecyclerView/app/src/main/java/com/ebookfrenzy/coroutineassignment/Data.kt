package com.ebookfrenzy.coroutineassignment


data class Data(val name:String){
    companion object{
        var globalList = ArrayList<String>()
        var preventDuplication: Boolean = false
    }
/*
globalList is used to store data from the activity. The outputTextfield in activity_main is used to
concatenate a string. (See MainViewModel.OutputStringBuilder). That value is observed and sent to
global list.

preventDuplication is set to ...preventDuplication. When onCreate() from ActivityMain.kt is called,
(I think), the value of outputTextField is being observed which causes a duplicate entry into the list.
To fix, I added this global boolean, which is set to true when the button is pressed and set to false
when onCreate() is called.

Overall this works by:
    1. DataBinding values with the UI
    2. UI values are observed
    3. OnClick grabs the LiveData from the inputTextField
    4. A coroutine is launched from the OnClick and generates an output to OutputTextField
    5. OutputTextfield is observed and this value is added to globalList. Note: OutputTextfield is
    hidden from the user, but can be see on activity_main.xml.
    6. The recyclerAdapater is notified of changes within the observer within the activity.

*/

}
