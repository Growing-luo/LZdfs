package com.growing.dfs.namenode.fs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class INodeDirectory extends INode{

  private List<INode> childen = null;

  public INodeDirectory(INode parent, long id, String name, String user,
               String group, long modificationTime,
               long accessTime) {
    this(parent, id, name, user, group, modificationTime,
      accessTime, null);
  }

  public INodeDirectory(INode parent, long id, String name, String user,
                        String group, long modificationTime,
                        long accessTime, Map<String,String> xAttr) {
    super(parent, id, name, user, group, modificationTime,
      accessTime, xAttr);
  }

  public boolean addChild(INode node) {
    if (childen != null && childen.contains(node)) {
      return false;
    } else if (childen == null){
      childen = new ArrayList<>();
    }
    node.setParent(this);
    childen.add(node);
    if (node.getGroup() == null) {
      node.setGroup(getGroup());
    }
    return true;
  }

  public INode getChild(String name) {
    for (int i = 0; i < childen.size(); i++) {
      if (childen.get(i).getName().equals(name)) {
        return childen.get(i);
      }
    }
    return null;
  }

  public boolean removeChild(String name) {
    for (int i = 0; i < childen.size(); i++) {
      if (childen.get(i).getName().equals(name)) {
        childen.remove(i);
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean isDirectory() {
    return true;
  }

  @Override
  public boolean isFile() {
    return false;
  }
}
