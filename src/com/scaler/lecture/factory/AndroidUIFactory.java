package com.scaler.lecture.factory;

import com.scaler.lecture.factory.buttons.AndroidButton;
import com.scaler.lecture.factory.buttons.Button;
import com.scaler.lecture.factory.dropdowns.AndroidDropdown;
import com.scaler.lecture.factory.dropdowns.Dropdown;
import com.scaler.lecture.factory.menus.AndroidMenu;
import com.scaler.lecture.factory.menus.Menu;

public class AndroidUIFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new AndroidButton();
    }

    @Override
    public Menu createMenu() {
        return new AndroidMenu();
    }

    @Override
    public Dropdown createDropdown() {
        return new AndroidDropdown();
    }
}
