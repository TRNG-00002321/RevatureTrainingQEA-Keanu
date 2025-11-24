from sqlalchemy import create_engine, MetaData, Table, Column, Integer, String, select, insert, update, delete

engine = create_engine('mysql://root:ppp444@localhost/classicmodels')

meta = MetaData()

test = Table('test', meta,
             Column('id', Integer, primary_key=True),
             Column('name', String(50)),
             Column('age', Integer))

meta.create_all(engine)

conn = engine.connect()

insert_stmt = insert(test).values(name='Keanu', age=25)
insert_stmt2 = insert(test).values(name='Joe', age=20)
insert_stmt3 = insert(test).values(name='Bob', age=30)

conn.execute(insert_stmt)
conn.execute(insert_stmt2)
conn.execute(insert_stmt3)
conn.commit()

select_stmt = select(test).where(test.c.name == 'Keanu')
rows = conn.execute(select_stmt)
print(rows.fetchone()[1] + " " + str(rows.fetchone()[2]))

update_stmt = update(test).where(test.c.name == 'Bob').values(age=45)
conn.execute(update_stmt)
conn.commit()

delete_stmt = delete(test).where(test.c.name == 'Keanu')
conn.execute(delete_stmt)
conn.commit()

conn.close()

