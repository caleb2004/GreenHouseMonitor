package com.example.greenglobal.greenhousemonitor;

/**
 * Created by Matt on 2017-06-08.
 */

import org.androidannotations.rest.spring.annotations.Accept;
import org.junit.Test;
import static junit.framework.Assert.*;

//some unit tests

public class UnitTest {

    @Test
    public void lightLevelsIsNotNull() throws Exception{
        double lightLevel = 10;

        assertNotNull(lightLevel);
    }

    @Test
    public void humidityLevelsIsNotNull() throws Exception {
        double humidityLevel = 10;

        assertNotNull(humidityLevel);
    }



}