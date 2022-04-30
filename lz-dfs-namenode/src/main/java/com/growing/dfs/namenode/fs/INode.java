package com.growing.dfs.namenode.fs;

import java.util.HashMap;
import java.util.Map;

public abstract class INode {

  final private long id;
  private String name;
  private String user;
  private String group ;
  private long modificationTime = 0L;
  private long accessTime = 0L;
  private Map<String,String> xAttrs;

  private INode parent;

  public INode(INode parent, long id, String name, String user,
               String group, long modificationTime,
               long accessTime) {
    this(parent, id, name, user, group, modificationTime,
      accessTime, null);
  }

  public INode(INode parent, long id, String name, String user,
                String group, long modificationTime,
                long accessTime, Map<String,String> xAttrs) {
    this.parent = parent;
    this.id = id;
    this.name = name;
    this.user = user;
    this.group = group;
    this.modificationTime = modificationTime;
    this.accessTime = accessTime;
    this.xAttrs = xAttrs;
  }


  public abstract boolean isDirectory();

  public abstract boolean isFile();

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getUser() {
    return user;
  }

  public String getGroup() {
    return group;
  }

  public INode getParent() {
    return parent;
  }

  public Map<String, String> getXAttrs() {
    return xAttrs;
  }

  public String getXAttr(String xAttrName) {
    if (xAttrs != null && !xAttrs.isEmpty()) {
      return xAttrs.get(xAttrName);
    }
    return null;
  }

  public void addXAttr(String xAttrName,
                          String xAttrValue) {
    if (xAttrs == null) {
      xAttrs = new HashMap<>();
    }
    xAttrs.put(xAttrName, xAttrValue);
  }

  public long getModificationTime() {
    return modificationTime;
  }

  public long getAccessTime() {
    return accessTime;
  }

  public void setAccessTime(long accessTime) {
    this.accessTime = accessTime;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setUser(String user) {
    this.user = user;
  }

  public void setGroup(String group) {
    this.group = group;
  }

  public void setModificationTime(long modificationTime) {
    this.modificationTime = modificationTime;
  }

  public void setXAttrs(Map<String, String> xAttrs) {
    this.xAttrs = xAttrs;
  }

  public void setParent(INode parent) {
    this.parent = parent;
  }

}
