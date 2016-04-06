public abstract class Plant extends Organism {
       protected float timebuffer;
   /** \brief Plant Constructor
    *
    * \param u universe it belongs in
    *
    */
       public Plant(Universe u, int x, int y,float currentAge){
           super(u,x,y,currentAge);
           timebuffer = 0;
       }

  /** \brief do the logic of plant growing
    *
    * \return void
    *
    */
       protected void update_grow(){}

   /** \brief grow new plant of the same class to the cell beside
    *
    * \return void
    *
    */
       protected abstract void grow();

   /** \brief time between producing another plant
    *
    * \return float the time between
    *
    */
       protected abstract float tgrow();

   /** \brief update the plant
    *
    * \param see Organism::update
    * \return void
    *
    */
       public void update(float dt){
           super.update(dt);
           if( isDead() ) return;

           float d = 1000/tgrow();
           timebuffer += dt;

           while( timebuffer > d ){
               update_grow();
               timebuffer -= d;
           }
       }
   /** \brief update the plant
    *
    * \param see Organism::update
    * \return void
    *
    */
       public float getTimebuffer(){
            return timebuffer;
       }
}