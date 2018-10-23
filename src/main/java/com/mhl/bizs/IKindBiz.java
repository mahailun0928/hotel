package com.mhl.bizs;
import com.mhl.model.*;
import java.util.List;
public interface IKindBiz{
	public boolean save(Kind kind);
	public boolean dele(int id);
	public Kind seleone(int id);
	public List<Kind> sele();
}