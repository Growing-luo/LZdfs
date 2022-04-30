package com.growing.dfs.namenode.fs;

import java.util.Map;

public class INodeFile extends INode {

  private String[] storagesInfo;

  private short replication;

  public INodeFile(INode parent, long id, String name, String user,
                        String group, long modificationTime,
                        long accessTime, short replication) {
    this(parent, id, name, user, group, modificationTime,
      accessTime, null, replication);
  }

  public INodeFile(INode parent, long id, String name, String user,
                        String group, long modificationTime,
                        long accessTime, Map<String,String> xAttr,
                        short replication) {
    super(parent, id, name, user, group, modificationTime,
      accessTime, xAttr);
    this.replication = replication;
  }

  public String[] getStoragesInfo() {
    return storagesInfo;
  }

  public void setStoragesInfo(String[] storagesInfo) {
    this.storagesInfo = storagesInfo;
  }

  public short getReplication() {
    return replication;
  }

  public void setReplication(short replication) {
    this.replication = replication;
  }

  @Override
  public boolean isDirectory() {
    return false;
  }

  @Override
  public boolean isFile() {
    return true;
  }
}
