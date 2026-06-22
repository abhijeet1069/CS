#include<stdio.h>
#include<pthread.h>

void *worker(){
    return "Fe Fi Fo Fum";
}

int main(){
    pthread_t t;
    pthread_create(&t, NULL, worker, NULL);

    void *result;
    
    pthread_join(t,&result);

    printf("%s\n",(char *)result);
    return 0;
}