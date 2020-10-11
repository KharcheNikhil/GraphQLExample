package com.turvo.graphqltutorial.model;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public interface MyCacheable {
    static String cacheName(){
      return "GLOBAL";
    }
}
