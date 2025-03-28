using Microsoft.EntityFrameworkCore;
using TDSPG.API.Domain.Entity;
using TDSPG.API.Infrastructure.Mappings;

namespace TDSPG.API.Infrastructure.Context
{
    public class TDSPGContext(DbContextOptions<TDSPGContext> options) : DbContext(options)
    {
        public DbSet<Establishment> Establishments { get; set; }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.ApplyConfiguration(new EstablishmentMapping());
        }
    }
}
