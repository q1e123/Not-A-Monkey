package view;

import controller.AccountManager;
import controller.ActionDBFactory;
import controller.BrowserManager;

public abstract class UserInterfaceAbstract {
    protected AccountManager accountManager = null;
    protected ActionDBFactory actionDBFactory = null;

    protected BrowserManager browserManager = null;
    public abstract void run();

    protected abstract void createNewAccount();
    protected abstract void login();

    protected abstract void addRoutine();
    protected abstract void addBrowser();

    protected abstract void executeRoutine();
}
