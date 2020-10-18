package com.company.text.factory;

import com.company.text.Text;

import java.io.IOException;
import java.nio.file.Path;

public interface Factory {
    Text getText(String text);
    Text getText(Path path) throws IOException;
}
