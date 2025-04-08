namespace TDSPG.API.Domain.Entity
{
    internal class Customer : Audit, IEntity
    {
        public Guid Id { get; set; }

        public string Name { get; set; }

        public override string GetInfo()
        {
            return $"Cliente criado por {UserCreated} em {CreatedAt}";
        }

        public string GetInfo2()
        {
            return $"Cliente 2 criado por {UserCreated} em {CreatedAt}";
        }
    }
}