'use client';

import Header from '@/components/Header';
import TaskInput from '@/components/CreateTaskInput';
import TaskCard from '@/components/TaskCard';
import { useEffect, useState } from 'react';
import Task from '@/interface/Task';
import createTasksList from './api/test';

export default function Home() {

  const [listaTask, setListaTask] = useState<Task[]>([])

  useEffect(() => {
    createTaskList();
  }, []);

  async function createTaskList(){
    createTasksList().then((data) => {
      setListaTask(data as Task[]);
      console.log(data)
    });    
  }

  return (
    <main>
      <Header />
      <TaskInput />

      <div className='flex flex-wrap place-content-center gap-3'>
        
        {listaTask.map((todo) => (
          <TaskCard id={todo.id} nome={todo.nome} />
        ))}
      </div>

    </main>
  );
}
