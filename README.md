The app is the basic activity with embedded fragment template from android studio
with two differences. First, the `PlaceholderFragment f` is added to to the back
stack and, second, an enter transition is set for `f`. Running the app and clicking
the back button leads to the following error message:

    12-16 22:35:35.503  15923-15923/exterminator.fragmenttransitionbug E/AndroidRuntime﹕ FATAL EXCEPTION: main
    Process: exterminator.fragmenttransitionbug, PID: 15923
    java.lang.NullPointerException: Attempt to invoke virtual method 'boolean android.support.v4.app.Fragment.getAllowReturnTransitionOverlap()' on a null object reference
            at android.support.v4.app.BackStackRecord.configureTransitions(BackStackRecord.java:1201)
            at android.support.v4.app.BackStackRecord.beginTransition(BackStackRecord.java:1029)
            at android.support.v4.app.BackStackRecord.popFromBackStack(BackStackRecord.java:883)
            at android.support.v4.app.FragmentManagerImpl.popBackStackState(FragmentManager.java:1541)
            at android.support.v4.app.FragmentManagerImpl.popBackStackImmediate(FragmentManager.java:502)
            at android.support.v4.app.FragmentActivity.onBackPressed(FragmentActivity.java:176)
            at android.support.v7.app.ActionBarActivity.onBackPressed(ActionBarActivity.java:298)
            at android.app.Activity.onKeyUp(Activity.java:2453)
            at android.view.KeyEvent.dispatch(KeyEvent.java:2633)
            at android.app.Activity.dispatchKeyEvent(Activity.java:2704)
            at com.android.internal.policy.impl.PhoneWindow$DecorView.dispatchKeyEvent(PhoneWindow.java:2221)
            at android.view.ViewRootImpl$ViewPostImeInputStage.processKeyEvent(ViewRootImpl.java:3918)
            at android.view.ViewRootImpl$ViewPostImeInputStage.onProcess(ViewRootImpl.java:3880)
            at android.view.ViewRootImpl$InputStage.deliver(ViewRootImpl.java:3449)
            at android.view.ViewRootImpl$InputStage.onDeliverToNext(ViewRootImpl.java:3502)
            at android.view.ViewRootImpl$InputStage.forward(ViewRootImpl.java:3468)
            at android.view.ViewRootImpl$AsyncInputStage.forward(ViewRootImpl.java:3578)
            at android.view.ViewRootImpl$InputStage.apply(ViewRootImpl.java:3476)
            at android.view.ViewRootImpl$AsyncInputStage.apply(ViewRootImpl.java:3635)
            at android.view.ViewRootImpl$InputStage.deliver(ViewRootImpl.java:3449)
            at android.view.ViewRootImpl$InputStage.onDeliverToNext(ViewRootImpl.java:3502)
            at android.view.ViewRootImpl$InputStage.forward(ViewRootImpl.java:3468)
            at android.view.ViewRootImpl$InputStage.apply(ViewRootImpl.java:3476)
            at android.view.ViewRootImpl$InputStage.deliver(ViewRootImpl.java:3449)
            at android.view.ViewRootImpl$InputStage.onDeliverToNext(ViewRootImpl.java:3502)
            at android.view.ViewRootImpl$InputStage.forward(ViewRootImpl.java:3468)
            at android.view.ViewRootImpl$AsyncInputStage.forward(ViewRootImpl.java:3611)
            at android.view.ViewRootImpl$ImeInputStage.onFinishedInputEvent(ViewRootImpl.java:3772)
            at android.view.inputmethod.InputMethodManager$PendingEvent.run(InputMethodManager.java:2208)
            at android.view.inputmethod.InputMethodManager.invokeFinishedInputEventCallback(InputMethodManager.java:1849)
            at android.view.inputmethod.InputMethodManager.finishedInputEvent(InputMethodManager.java:1840)
            at android.view.inputmethod.InputMethodManager$ImeInputEventSender.onInputEventFinished(InputMethodManager.java:2185)
            at android.view.InputEventSender.dispatchInputEventFinished(InputEventSender.java:141)
            at android.os.MessageQueue.nativePollOnce(Native Method)
            at android.os.MessageQueue.next(MessageQueue.java:143)
            at android.os.Looper.loop(Looper.java:122)
            at android.app.ActivityThread.main(ActivityThread.java:5221)
            at java.lang.reflect.Method.invoke(Native Method)
            at java.lang.reflect.Method.invoke(Method.java:372)
            at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:899)
            at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:694)

Removing the support library leads to the following error message:

    12-16 22:43:53.897  16483-16483/exterminator.fragmenttransitionbug E/AndroidRuntime﹕ FATAL EXCEPTION: main
    Process: exterminator.fragmenttransitionbug, PID: 16483
    java.lang.NullPointerException: Attempt to read from field 'int android.app.Fragment.mContainerId' on a null object reference
            at android.app.BackStackRecord$1.onPreDraw(BackStackRecord.java:1127)
            at android.view.ViewTreeObserver.dispatchOnPreDraw(ViewTreeObserver.java:847)
            at android.view.ViewRootImpl.performTraversals(ViewRootImpl.java:1956)
            at android.view.ViewRootImpl.doTraversal(ViewRootImpl.java:1054)
            at android.view.ViewRootImpl$TraversalRunnable.run(ViewRootImpl.java:5779)
            at android.view.Choreographer$CallbackRecord.run(Choreographer.java:767)
            at android.view.Choreographer.doCallbacks(Choreographer.java:580)
            at android.view.Choreographer.doFrame(Choreographer.java:550)
            at android.view.Choreographer$FrameDisplayEventReceiver.run(Choreographer.java:753)
            at android.os.Handler.handleCallback(Handler.java:739)
            at android.os.Handler.dispatchMessage(Handler.java:95)
            at android.os.Looper.loop(Looper.java:135)
            at android.app.ActivityThread.main(ActivityThread.java:5221)
            at java.lang.reflect.Method.invoke(Native Method)
            at java.lang.reflect.Method.invoke(Method.java:372)
            at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:899)
            at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:694)


Note that if no transition is set for `f` then there is no exception and everything's fine.