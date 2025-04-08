namespace TDSPG.API.Domain.Entity
{
    internal class Order : Audit
    {
        public Guid Id { get; set; }

        public int Number { get; set; }
    }
}