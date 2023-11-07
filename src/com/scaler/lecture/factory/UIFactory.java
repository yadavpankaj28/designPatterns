package com.scaler.lecture.factory;

import com.scaler.lecture.factory.buttons.Button;
import com.scaler.lecture.factory.dropdowns.Dropdown;
import com.scaler.lecture.factory.menus.Menu;

public interface UIFactory {
    public Button createButton();
    public Menu createMenu();
    public Dropdown createDropdown();
}
