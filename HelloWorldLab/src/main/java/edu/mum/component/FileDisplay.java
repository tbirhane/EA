package edu.mum.component;

import java.io.IOException;

public interface FileDisplay {
    void display() throws IOException;
    MessageOrigin getMessageSource();

}
