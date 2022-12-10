#include <iostream>
#include <vector>
using namespace std;
template <typename T>
class CTreeDynamic;
template <typename T>
class CNodeDynamic {

private:
    vector<CNodeDynamic<T>*> v_children;
    CNodeDynamic<T>* pc_parent_node;
    T i_val;
public:
    CNodeDynamic();
    ~CNodeDynamic();

    void vSetValue(T iNewVal);
    int iGetChildrenNumber();
    void vAddNewChild();
    void vAddNewChild(CNodeDynamic<T>* pcNewChildNode);
    CTreeDynamic<T>* pcGetChild(int iChildOffset);
    void vEraseFromParentVector(CNodeDynamic<T>* pcEraseChildNode);

    void vPrint();
    void vPrintAllBelow();
    T getIValue();
    int iCount(T iVal);
    T ptMul();
    CNodeDynamic<T>* pcFindRoot();
    CNodeDynamic<T>* pcGetParent();

};


template <typename T>
class CTreeDynamic {

private:
    CNodeDynamic<T>* pc_root;
public:
    CTreeDynamic();
    ~CTreeDynamic();

    bool bMoveSubtree(CNodeDynamic<T>* pcParentNode, CNodeDynamic<T>* pcNewChildNode);
    CNodeDynamic<T>* pcGetRoot();
    void vPrintFullTree();
    void vSetRoot(CNodeDynamic<T>* newRootNode);
    int iCount(T iVal);
    T* ptMul();
};


template <typename T>
CTreeDynamic<T>::CTreeDynamic() {
    pc_root = new CNodeDynamic<T>();
}

template <typename T>
CTreeDynamic<T>::~CTreeDynamic() {
    delete pc_root;
}

template <typename T>
void CTreeDynamic<T>::vPrintFullTree() {
    pc_root->vPrintAllBelow();
}

template <typename T>
void CTreeDynamic<T>::vSetRoot(CNodeDynamic<T>* newRootNode) {
    pc_root = newRootNode;
}

template <typename T>
int CTreeDynamic<T>::iCount(T iVal) {
    return pc_root->iCount(iVal);
}



template<>
 int* CTreeDynamic<int>::ptMul(){
     int* res = new int;
     *res = pc_root->ptMul();
     return res;
}
 template<>
 double* CTreeDynamic<double>::ptMul(){
     double* res = new double;
     *res = pc_root->ptMul();
     return res;
 }
 template<typename T>
 T* CTreeDynamic<T>::ptMul(){
     return NULL;
 }





template <typename T>
bool CTreeDynamic<T>::bMoveSubtree(CNodeDynamic<T>* pcParentNode, CNodeDynamic<T>* pcNewChildNode) {
    if (pcParentNode == NULL || pcNewChildNode == NULL || pcParentNode->pcFindRoot() == pcNewChildNode->pcFindRoot())
        return false;
    else if (pcNewChildNode->pcGetParent() == NULL) {
        pcParentNode->vAddNewChild(pcNewChildNode);
        return true;
    }
    else {
        CNodeDynamic<T>* pcNewChildParentNode = pcNewChildNode->pcGetParent();
        pcParentNode->vAddNewChild(pcNewChildNode);
        pcNewChildParentNode->vEraseFromParentVector(pcNewChildNode);
        return true;
    }
}


template <typename T>
CNodeDynamic<T>::CNodeDynamic() {
    pc_parent_node = NULL;
}

template <typename T>
CNodeDynamic<T>::~CNodeDynamic() {
    for (int i = 0; i < v_children.size(); i++) {
        delete v_children[i];
    }
}

template <typename T>
void CNodeDynamic<T>::vSetValue(T iNewVal) {
    i_val = iNewVal;
}

template <typename T>
int CNodeDynamic<T>::iGetChildrenNumber() {
    return v_children.size();
}

template <typename T>
void CNodeDynamic<T>::vAddNewChild() {
    CNodeDynamic<T>* child = new CNodeDynamic<T>;
    child->pc_parent_node = this;
    v_children.push_back(child);
}

template <typename T>
void CNodeDynamic<T>::vAddNewChild(CNodeDynamic<T>* pcNewChildNode) {
    pcNewChildNode->pc_parent_node = this;
    v_children.push_back(pcNewChildNode);
}

template <typename T>
CTreeDynamic<T>* CNodeDynamic<T>::pcGetChild(int iChildOffset) {
    if ((iChildOffset >= 0) && (iChildOffset < v_children.size())) {
        CTreeDynamic<T>* newTree = new CTreeDynamic<T>();
        newTree->vSetRoot(v_children[iChildOffset]);
        return newTree;
    }
    return NULL;
}

template <typename T>
void CNodeDynamic<T>::vPrint() {
    cout << " " << i_val;
}

template <typename T>
void CNodeDynamic<T>::vPrintAllBelow() {
    vPrint();
    for (int i = 0; i < v_children.size(); i++) {
        v_children[i]->vPrintAllBelow();
    }
}

template <typename T>
T CNodeDynamic<T>::getIValue() {
    return i_val;
}

template <typename T>
int CNodeDynamic<T>::iCount(T iVal) {
    int counter = 0;
    if (i_val == iVal)
        counter++;
    for (int i = 0; i < v_children.size(); i++)
        counter += v_children[i]->iCount(iVal);

    return counter;
}

template<>
int CNodeDynamic<int>::ptMul()
{
    int counter = i_val;
        for (int i = 0; i < v_children.size(); i++)
            counter = counter * v_children[i]->ptMul();
        return counter;
}

template<>
double CNodeDynamic<double>::ptMul()
{
    double counter = i_val;
    for (int i = 0; i < v_children.size(); i++)
        counter = counter * v_children[i]->ptMul();
    return counter;
}

template <typename T>
CNodeDynamic<T>* CTreeDynamic<T>::pcGetRoot() {
    if (pc_root != NULL)
        return pc_root;
    return NULL;
}

template <typename T>
CNodeDynamic<T>* CNodeDynamic<T>::pcGetParent() {
    return pc_parent_node;
}

template <typename T>
CNodeDynamic<T>* CNodeDynamic<T>::pcFindRoot() {
    if (pc_parent_node != NULL)
        pc_parent_node->pcFindRoot();
    else
        return this;
}

template <typename T>
void CNodeDynamic<T>::vEraseFromParentVector(CNodeDynamic<T>* pcEraseChildNode) {
    for (int i = 0; i < v_children.size(); i++) {
        if (pcEraseChildNode == v_children.at(i))
            v_children.erase(v_children.begin() + i);
    }

}
