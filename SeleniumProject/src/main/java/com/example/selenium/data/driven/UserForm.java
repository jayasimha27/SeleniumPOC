/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.selenium.data.driven;

import java.util.List;

/**
 *
 * @author Jayasimha B J <jayasimha.bj@gmail.com>
 */
public class UserForm {

    private String text1;
    private String text2;
    private String filePath;
    private String textArea;
    private boolean checkBox1;
    private boolean checkBox2;
    private boolean checkBox3;
    private boolean radio1;
    private boolean radio2;
    private boolean radio3;
    private String dropDownSelect;
    private List<String> dropMultiSelect;

    public UserForm() {

    }

    public UserForm(String text1, String text2, String textArea,String filePath, boolean checkBox1, boolean checkBox2, boolean checkBox3,
            boolean radio1, boolean radio2, boolean radio3, String selectIndex, List<String> multiSelect) {
        this.text1 = text1;
        this.text2 = text2;
        this.filePath = filePath;
        this.textArea = textArea;
        this.checkBox1 = checkBox1;
        this.checkBox2 = checkBox2;
        this.checkBox3 = checkBox3;
        this.radio1 = radio1;
        this.radio2 = radio2;
        this.radio3 = radio3;
        this.dropDownSelect = selectIndex;
        this.dropMultiSelect = multiSelect;

    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getTextArea() {
        return textArea;
    }

    public void setTextArea(String textArea) {
        this.textArea = textArea;
    }

    public boolean isCheckBox1() {
        return checkBox1;
    }

    public void setCheckBox1(boolean checkBox1) {
        this.checkBox1 = checkBox1;
    }

    public boolean isCheckBox2() {
        return checkBox2;
    }

    public void setCheckBox2(boolean checkBox2) {
        this.checkBox2 = checkBox2;
    }

    public boolean isCheckBox3() {
        return checkBox3;
    }

    public void setCheckBox3(boolean checkBox3) {
        this.checkBox3 = checkBox3;
    }

    public boolean isRadio1() {
        return radio1;
    }

    public void setRadio1(boolean radio1) {
        this.radio1 = radio1;
    }

    public boolean isRadio2() {
        return radio2;
    }

    public void setRadio2(boolean radio2) {
        this.radio2 = radio2;
    }

    public boolean isRadio3() {
        return radio3;
    }

    public void setRadio3(boolean radio3) {
        this.radio3 = radio3;
    }

    public String getDropDownSelect() {
        return dropDownSelect;
    }

    public void setDropDownSelect(String dropDownSelect) {
        this.dropDownSelect = dropDownSelect;
    }

    public List<String> getDropMultiSelect() {
        return dropMultiSelect;
    }

    public void setDropMultiSelect(List<String> dropMultiSelect) {
        this.dropMultiSelect = dropMultiSelect;
    }

}
