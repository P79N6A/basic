package com.itcast.basic.stringtype.basicabstractstring;

import com.itcast.basic.stringtype.basicabstract.BasicAbstractStringBuilder;
import com.itcast.basic.stringtype.basicinterface.BasicAppendable;
import com.itcast.basic.stringtype.basicinterface.BasicCharSequence;
import com.itcast.basic.stringtype.basicstring.BasicString;

/**
 * Created by qfl on 16/4/20.
 */
public final class BasicStringBulider extends BasicAbstractStringBuilder {
    public BasicStringBulider() {
        super(16);
    }

    @Override
    public BasicStringBulider append(BasicString s) {
        super.append(s);
        return this;
    }

    @Override
    public int length() {
        return capacity();
    }

    @Override
    public char charAt(int index) {
        return 0;
    }

    @Override
    public BasicCharSequence subSequence(int start, int end) {
        return null;
    }
}
