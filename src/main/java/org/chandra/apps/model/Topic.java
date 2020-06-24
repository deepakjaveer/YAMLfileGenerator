package org.chandra.apps.model;

public class Topic {
private String source;
private String market;
private String project;
private String topicName;
private String type;
private String datatype;
private Double replicationFactor;
private Double numPartitions;

    public Topic(String source, String market, String project, String topicName, String type, String datatype, Double replicationFactor, Double numPartitions) {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDatatype() {
        return datatype;
    }

    public void setDatatype(String datatype) {
        this.datatype = datatype;
    }

    public Double getReplicationFactor() {
        return replicationFactor;
    }

    public void setReplicationFactor(Double replicationFactor) {
        this.replicationFactor = replicationFactor;
    }

    public Double getNumPartitions() {
        return numPartitions;
    }

    public void setNumPartitions(Double numPartitions) {
        this.numPartitions = numPartitions;
    }



    @Override
    public String toString() {
        return "Topic{" +
                "source='" + source + '\'' +
                ", market='" + market + '\'' +
                ", project='" + project + '\'' +
                ", topicName='" + topicName + '\'' +
                '}';
    }




    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }


    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }


}
