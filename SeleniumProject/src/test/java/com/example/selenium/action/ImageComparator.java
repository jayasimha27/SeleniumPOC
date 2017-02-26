/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.selenium.action;

import com.example.selenium.util.ImageCompareUtil;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

/**
 *
 * @author Jayasimha B J <jayasimha.bj@gmail.com>
 */
public class ImageComparator {

    @Test
    public void testBmiCalculatorLayout() throws Exception {

        String scrFile1 = "src/test/resources/data/graph1.png";
        String baseScrFile1 = "src/test/resources/data/graph2.png";

        // Open the BMI Calculator Page and get a Screen Shot of Page into a
        // File
        // Verify baseline image with actual image
        assertEquals(ImageCompareUtil.Result.Matched,
                ImageCompareUtil.CompareImage(baseScrFile1, scrFile1));

    }

}
