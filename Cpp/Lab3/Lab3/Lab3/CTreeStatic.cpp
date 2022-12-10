#include <iostream>
#include <vector>
#include "CTreeStatic.h"

using namespace std;



CNodeStatic::CNodeStatic() {
    i_val = 0;
    pc_parent_node = NULL;
}

void CNodeStatic::vSetValue(int iNewVal) {
    i_val = iNewVal;
}

int CNodeStatic::iGetChildrenNumber() {
    return v_children.size();
}

void CNodeStatic::vAddNewChild() {
    CNodeStatic new_child;
    new_child.setParentNode(this);
    v_children.push_back(new_child);

}

CNodeStatic* CNodeStatic::pcGetChild(int iChildOffset) {
    if (iChildOffset >= 0 && iChildOffset < v_children.size())
        return &v_children[iChildOffset];
    return NULL;
}

void CNodeStatic::vPrint() {
    cout << i_val << " ";
}
void CNodeStatic::vPrintAllBelow() {
    vPrint();
    for (int i = 0; i < v_children.size(); i++)
        v_children[i].vPrintAllBelow();
}

void CNodeStatic::setParentNode(CNodeStatic* node) {
    pc_parent_node = node;
}

CNodeStatic* CNodeStatic::pcGetParent() {
    return pc_parent_node;
}


void CNodeStatic::vDeleteChild(CNodeStatic* pcChild) {
    for (int i = 0; i < v_children.size(); i++) {
        if (&v_children[i] == pcChild) {
            v_children.erase(v_children.begin() + i);
        }
    }
}


void CNodeStatic::vPrintUp() {
    vPrint();
    if (pc_parent_node != nullptr)
        pc_parent_node->vPrintUp();
}


CTreeStatic::CTreeStatic() {
    c_root = CNodeStatic();
}


CNodeStatic* CTreeStatic::pcGetRoot() {
    return &c_root;
}
void CTreeStatic::vPrintFullTree() {
    c_root.vPrintAllBelow();
}
void CNodeStatic::vCopySubtree(CNodeStatic* pcParent) {
    pcParent->vAddNewChild();
    vector<CNodeStatic>* vParentChildren = &(pcParent->v_children);
    CNodeStatic* newNode = &(vParentChildren->at(vParentChildren->size() - 1));
    newNode->i_val = this->i_val;
    for (int i = 0; i < v_children.size(); i++) {
        (v_children.at(i)).vCopySubtree(newNode);
    }
}

bool CTreeStatic::bMoveSubtree(CNodeStatic* pcParentNode, CNodeStatic* pcNewChildNode) {
    if ((pcNewChildNode != NULL) && (pcParentNode != NULL)) {

        pcNewChildNode->vCopySubtree(pcParentNode);
        CNodeStatic* pcNewChildParent = pcNewChildNode->pcGetParent();
        if (pcNewChildParent == NULL) {
            delete pcNewChildNode;
        }
        else {
            pcNewChildParent->vDeleteChild(pcNewChildNode);
        }
            return true;
    }
    return false;
}


