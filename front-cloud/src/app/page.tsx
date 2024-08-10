'use client';

import Header from '@/components/Header';
import TaskInput from '@/components/CreateTaskInput';
import TaskCard from '@/components/TaskCard';
import { useEffect, useState } from 'react';
import { todo } from 'node:test';
import Task from '@/interface/Task';

export default function Home() {

  const [listaTask, setListaTask] = useState<Task[]>([])

  useEffect(() => {
    createTaskList();
  });

  async function createTaskList(){
    const response = await fetch('http://localhost:8088/aws/task');
    const data = await response.json();

    setListaTask(data)
    console.log(data)
  }

  return (
    <main>
      <Header />
      <TaskInput />

      <div className='flex flex-wrap place-content-center gap-3'>
        
        {listaTask.map((todo) => (
          <TaskCard id={todo.id} nome={todo.nome} />
        ))}
        
        <TaskCard 
        id={1}
        nome='asdadad'
        />
      </div>

    </main>
  );
}
