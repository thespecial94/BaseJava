package com.basejava.webapp.storage;

import com.basejava.webapp.Config;

import static org.junit.Assert.*;

public class SqlStorageTest extends  AbstractStorageTest {

    public SqlStorageTest() {
        super(Config.get().getStorageResumes());
    }
}