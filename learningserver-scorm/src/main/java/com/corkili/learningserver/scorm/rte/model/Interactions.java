package com.corkili.learningserver.scorm.rte.model;

import com.corkili.learningserver.scorm.rte.model.annotation.Meta;
import com.corkili.learningserver.scorm.rte.model.datatype.AbstractCollectionDataType;
import com.corkili.learningserver.scorm.rte.model.datatype.CharacterString;
import com.corkili.learningserver.scorm.rte.model.datatype.GeneralDataType;
import com.corkili.learningserver.scorm.rte.model.datatype.Int;
import com.corkili.learningserver.scorm.rte.model.datatype.LocalizedString;
import com.corkili.learningserver.scorm.rte.model.datatype.LongIdentifier;
import com.corkili.learningserver.scorm.rte.model.datatype.Real7;
import com.corkili.learningserver.scorm.rte.model.datatype.State;
import com.corkili.learningserver.scorm.rte.model.datatype.Time;
import com.corkili.learningserver.scorm.rte.model.datatype.TimeInterval;

public class Interactions extends AbstractCollectionDataType<Interactions.Instance> {

    @Meta(value = "_children", writable = false)
    private CharacterString children;

    @Meta(value = "_count", writable = false)
    private Int count;

    public Interactions() {
        children = new CharacterString("id,type,objectives,timestamp,correct_responses,weighting,learner_response," +
                "result,latency,description");
        count = new Int(0);
    }

    @Override
    protected Instance newInstance() {
        count.set(String.valueOf(Integer.parseInt(count.get()) + 1));
        return new Instance();
    }

    public CharacterString getChildren() {
        return children;
    }

    public void setChildren(CharacterString children) {
        this.children = children;
    }

    public Int getCount() {
        return count;
    }

    public void setCount(Int count) {
        this.count = count;
    }

    public static class Instance implements GeneralDataType {

        @Meta("id")
        private LongIdentifier id;

        @Meta("type")
        private State type;

        @Meta("objectives")
        private InteractionsObjectives objectives;

        @Meta("timestamp")
        private Time timestamp;

        @Meta("correct_responses")
        private CorrectResponses correctResponses;

        @Meta("weighting")
        private Real7 weighting;

        @Meta("learner_response")
        private LearnerResponse learnerResponse;

        @Meta("result")
        private Result result;

        @Meta("latency")
        private TimeInterval latency;

        @Meta("description")
        private LocalizedString description;

        public Instance() {
            this.id = new LongIdentifier();
            this.type = new State(new String[]{"true_false", "multiple_choice", "fill_in", "long_fill_in", "matching",
                    "performance", "sequencing", "likert", "numeric", "other"});
            this.objectives = new InteractionsObjectives();
            this.timestamp = new Time();
            this.correctResponses = new CorrectResponses();
            this.weighting = new Real7();
            this.result = new Result();
            this.description = new LocalizedString();
        }

        public LongIdentifier getId() {
            return id;
        }

        public void setId(LongIdentifier id) {
            this.id = id;
        }

        public State getType() {
            return type;
        }

        public void setType(State type) {
            this.type = type;
        }

        public InteractionsObjectives getObjectives() {
            return objectives;
        }

        public void setObjectives(InteractionsObjectives objectives) {
            this.objectives = objectives;
        }

        public Time getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(Time timestamp) {
            this.timestamp = timestamp;
        }

        public CorrectResponses getCorrectResponses() {
            return correctResponses;
        }

        public void setCorrectResponses(CorrectResponses correctResponses) {
            this.correctResponses = correctResponses;
        }

        public Real7 getWeighting() {
            return weighting;
        }

        public void setWeighting(Real7 weighting) {
            this.weighting = weighting;
        }

        public LearnerResponse getLearnerResponse() {
            return learnerResponse;
        }

        public void setLearnerResponse(LearnerResponse learnerResponse) {
            this.learnerResponse = learnerResponse;
        }

        public Result getResult() {
            return result;
        }

        public void setResult(Result result) {
            this.result = result;
        }

        public TimeInterval getLatency() {
            return latency;
        }

        public void setLatency(TimeInterval latency) {
            this.latency = latency;
        }

        public LocalizedString getDescription() {
            return description;
        }

        public void setDescription(LocalizedString description) {
            this.description = description;
        }
    }

}
