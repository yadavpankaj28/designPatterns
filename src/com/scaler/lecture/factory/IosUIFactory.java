package com.scaler.lecture.factory;

import com.scaler.lecture.factory.buttons.Button;
import com.scaler.lecture.factory.buttons.IosButton;
import com.scaler.lecture.factory.dropdowns.Dropdown;
import com.scaler.lecture.factory.dropdowns.IosDropdown;
import com.scaler.lecture.factory.menus.IosMenu;
import com.scaler.lecture.factory.menus.Menu;

public class IosUIFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new IosButton();
    }

    @Override
    public Menu createMenu() {
        return new IosMenu();
    }

    @Override
    public Dropdown createDropdown() {
        return new IosDropdown();
    }
}
