package com.corkili.learningserver.scorm.rte.model.datatype;

import com.corkili.learningserver.scorm.rte.model.error.ScormError;
import com.corkili.learningserver.scorm.rte.model.handler.GetHandler;
import com.corkili.learningserver.scorm.rte.model.handler.SetHandler;
import com.corkili.learningserver.scorm.rte.model.result.ScormResult;

public abstract class AbstractTerminalDataType implements TerminalDataType {

    private SetHandler setHandler;
    private GetHandler getHandler;

    public void setSetHandler(SetHandler setHandler) {
        this.setHandler = setHandler;
    }

    public void setGetHandler(GetHandler getHandler) {
        this.getHandler = getHandler;
    }

    protected ScormResult handleSet(Object context, String value) {
        if (setHandler != null) {
            return setHandler.handle(context, value);
        } else {
            return new ScormResult("true", ScormError.E_0);
        }
    }

    protected ScormResult handleGet(Object context) {
        if (getHandler != null) {
            return getHandler.handle(context);
        } else {
            return new ScormResult("", ScormError.E_0);
        }
    }

}
